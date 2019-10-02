package com.examples.rabbitmq.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PublishLog {

    private static final Logger logger = Logger.getLogger(PublishLog.class.getName());
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()){

            assert connection != null;
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            Scanner scanner = new Scanner(System.in);
            logger.info("\nKill the program by pressing CTRL+D\n[!] Enter new Message: ");

            while(scanner.hasNextLine()){
                String msg = scanner.nextLine();
                channel.basicPublish(EXCHANGE_NAME, "", MessageProperties.BASIC, msg.getBytes(StandardCharsets.UTF_8));
                logger.info("[X] Message sent successfully: '" + msg + "'");
                logger.info("\nKill the program by pressing CTRL+D\n[!] Enter new Message: ");
            }

        } catch (IOException | TimeoutException e){
            logger.log(Level.WARNING, e.getMessage());
            logger.info("[*] Attempt to restart service...");
            try {
                Thread.sleep(10000);
                main(new String[]{"restarted"});
            } catch (InterruptedException ex) {
                logger.log(Level.WARNING, ex.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
