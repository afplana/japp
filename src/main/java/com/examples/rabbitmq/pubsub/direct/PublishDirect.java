package com.examples.rabbitmq.pubsub.direct;

import com.examples.parse.ApacheLog;
import com.examples.parse.ApacheLogsSimpleParser;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.List;
import java.util.logging.Logger;

public class PublishDirect {

    private static Logger logger = Logger.getLogger(PublishDirect.class.getName());
    private static final String DIRECT_EXCHANGE_NAME = "direct_logs";


    public static void publishDirect(List<ApacheLog> apacheLogs) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(DIRECT_EXCHANGE_NAME, "direct");
        channel.basicPublish(DIRECT_EXCHANGE_NAME, ApacheLog.Method.GET.name().toLowerCase(), null, apacheLogs.toString().getBytes());
        logger.info("[!] Message sent through channel " +ApacheLog.Method.GET.name().toLowerCase()+ " -> " + apacheLogs.toString());
    }

    public static void main(String[] args) throws Exception {
        publishDirect(ApacheLogsSimpleParser.retrieveApacheLogs());
    }
}
