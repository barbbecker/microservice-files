package com.barbbecker.jtcore.parsercontent;

import com.barbbecker.jtcore.parsercontent.domain.DataId;
import com.barbbecker.jtcore.parsercontent.dto.DataDto;
import com.barbbecker.jtcore.parsercontent.file.GenerateReport;
import com.barbbecker.jtcore.parsercontent.file.ParserFile;
import com.barbbecker.jtcore.parsercontent.file.WriterFile;
import com.barbbecker.jtcore.parsercontent.service.DataAnalysis;
import com.google.gson.Gson;
import com.rabbitmq.client.*;

import java.util.ArrayList;
import java.util.List;

public class ReceiveFiles {

    private final static String QUEUE_NAME = "fileReportQueue";
    private final static String HOST = "localhost";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            Gson gson = new Gson();
            String message = new String(delivery.getBody(), "UTF-8");

            DataDto dataStringToJson = gson.fromJson(message, DataDto.class);


            System.out.println(" [x] Received '" + dataStringToJson.getContent() + "'");

            DataAnalysis dataAnalysis = new DataAnalysis();
            GenerateReport generateReport = new GenerateReport();

            List<String[]> formatData = ParserFile.parserForDatas(dataStringToJson.getContent());

            List<DataId> dataObjects = new ArrayList<>();
            for (String[] data : formatData) {
                dataObjects.add(dataAnalysis.verifyDatas(data));
            }

            List<String> result = generateReport.dataAnalyzed(dataObjects);


            WriterFile.prepareFileToReport(result, dataStringToJson.getPath());

        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }
}
