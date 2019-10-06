package ao.jfpack.rabbitmq.pubsub.direct;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class PublishDirect<T> {

    private static Logger logger = Logger.getLogger(PublishDirect.class.getName());
    private static final String DIRECT_EXCHANGE_NAME = "direct_book";


    public void publishDirect(T t) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(DIRECT_EXCHANGE_NAME, "direct");

            ObjectMapper mapper = new ObjectMapper()
                    .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

            String tAsString = mapper.writeValueAsString(t);
            channel.basicPublish(DIRECT_EXCHANGE_NAME, "book", null, tAsString.getBytes());
            logger.info("[!] Message sent through channel <get> -> " + tAsString);
        }
    }
}
