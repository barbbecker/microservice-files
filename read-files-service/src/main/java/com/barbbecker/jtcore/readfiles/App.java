package com.barbbecker.jtcore.readfiles;

import com.barbbecker.jtcore.readfiles.file.ConfigFile;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class App {

    private final static String QUEUE_NAME = "fileReportQueue";
    private final static String HOST = "localhost";

    public static void main(String[] args) throws Exception {
        ConfigFile.createFiles();

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(HOST);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        Watcher.startWatch(channel);
    }
}
