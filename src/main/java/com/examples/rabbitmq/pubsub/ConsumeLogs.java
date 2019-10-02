package com.examples.rabbitmq.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class ConsumeLogs {

    private static final Logger logger = Logger.getLogger(ConsumeLogs.class.getName());
    private static final String EXCHANGE_NAME = "logs";
    private static final String DIRECT_EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();

        consumeDirectExchange(connection, new String[]{"info"});

//        consumeFanoutExchange(connection);
    }

    private static void consumeDirectExchange(Connection connection, String[] args) throws IOException {
        assert connection != null;
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(DIRECT_EXCHANGE_NAME, "direct");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, DIRECT_EXCHANGE_NAME, "");

        if (args.length < 1) {
            logger.info("Usage: ReceiveLogsDirect [info] [warning] [error]");
            System.exit(1);
        }

        for (String severity : args)
            channel.queueBind(queueName, DIRECT_EXCHANGE_NAME, severity);

        logger.info("[*] Waiting for messages for direct exchange. To exit press CTRL+D");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            logger.info(" [x] Received: '" + delivery.getEnvelope().getRoutingKey() + message + "'");
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }

    private static void consumeFanoutExchange(Connection connection) throws IOException {
        assert connection != null;
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind(queueName, EXCHANGE_NAME, "");
        logger.info("[*] Waiting for messages. To exit press CTRL+D");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            logger.info(" [x] Received: '" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }

}
