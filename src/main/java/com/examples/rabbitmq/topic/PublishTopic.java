package com.examples.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;

public class PublishTopic {
    private static String EXCHANGE_NAME = "topic.logs";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();

        assert connection != null;
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String key = (args.length < 1) ? "anonymous.info" : args[0];
        String msg = (args.length < 2) ? "Hello World!" : joinStrings(args);

        channel.basicPublish(EXCHANGE_NAME, key, MessageProperties.TEXT_PLAIN, msg.getBytes(StandardCharsets.UTF_8));
        System.out.println("[!] Sent: " + key + " -> " + msg);
    }


    private static String joinStrings(String[] args) {

        int length = args.length;
        if (length == 0) return "";

        StringBuilder words = new StringBuilder(args[1]);
        for (int i = 1 + 1; i < length; i++)
            words.append(" ").append(args[i]);
        return words.toString();
    }
}
