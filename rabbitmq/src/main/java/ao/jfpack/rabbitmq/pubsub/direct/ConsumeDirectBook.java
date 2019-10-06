package ao.jfpack.rabbitmq.pubsub.direct;

import ao.jfpack.rabbitmq.mockob.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class ConsumeDirectBook {

    private static final String DIRECT_EXCHANGE_NAME = "direct_book";
    public static List<Book> books = new ArrayList<>();
    private static Logger logger = Logger.getLogger(ConsumeDirectBook.class.getName());

    private static void handleDeliveryFromChannel(String consumerTag, Delivery delivery) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Book book = mapper.readValue(delivery.getBody(), Book.class);
        books.add(book);
        String key = delivery.getEnvelope().getRoutingKey();
        logger.info(" [x] Received: '%nRouting key: " + key + " -> " + book.author + "'");
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(DIRECT_EXCHANGE_NAME, "direct");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, DIRECT_EXCHANGE_NAME, "book");

        logger.info("[*] Waiting for messages for direct exchange. To exit press CTRL+D");
        DeliverCallback deliverCallback = ConsumeDirectBook::handleDeliveryFromChannel;
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}