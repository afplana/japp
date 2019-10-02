package com.examples.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class Sender {

    private static Logger logger = Logger.getLogger(Sender.class.getName());
    private final static String TASK_QUEUE_NAME = "Task_queue";

    public static void main(String[] args) {
        publishTask(args);
    }

    private static void publishTask(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()){

            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

            Scanner scanner = new Scanner(System.in);
            logger.info("For exit the program enter CTRL+D \nPlease enter msg:");
            while(scanner.hasNextLine()) {
                String msg = scanner.nextLine();

                channel.basicPublish("", TASK_QUEUE_NAME,
                        MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes(StandardCharsets.UTF_8));
                logger.info("[x] Message sent '" + msg + "'");
                logger.info("For exit the program enter CTRL+D \nPlease enter msg:");
            }
            scanner.close();
        } catch (IOException | TimeoutException e) {
            logger.info(e.getMessage());
        }
    }
}
