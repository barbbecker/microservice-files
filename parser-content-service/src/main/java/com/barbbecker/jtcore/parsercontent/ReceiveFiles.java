package com.barbbecker.jtcore.parsercontent;

import com.barbbecker.jtcore.parsercontent.domain.Data;
import com.barbbecker.jtcore.parsercontent.file.GenerateReport;
import com.barbbecker.jtcore.parsercontent.file.ParserFile;
import com.barbbecker.jtcore.parsercontent.file.WriterFile;
import com.barbbecker.jtcore.parsercontent.service.DataAnalysis;
import com.rabbitmq.client.*;
import org.apache.commons.lang3.SerializationUtils;

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

            Data contentData = SerializationUtils.deserialize(delivery.getBody());

            System.out.println(" [x] Received '" + contentData.getContent() + "'");

            DataAnalysis dataAnalysis = new DataAnalysis();
            GenerateReport generateReport = new GenerateReport();

            List<String[]> formatData = ParserFile.parserForDatas(contentData.getContent());

            List<String> dataObjects = new ArrayList<>();
            for (String[] data : formatData) {
                dataObjects.add(dataAnalysis.verifyDatas(data));
            }

            List<String> result = generateReport.dataAnalyzed(dataObjects);

            WriterFile.prepareFileToReport(result, contentData.getPath());

        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }
}
