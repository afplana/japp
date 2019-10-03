package ao.jfpack.rabbitmq.pubsub.direct;

import ao.jfpack.parse.ApacheLog;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsumeDirect implements Runnable {

    private static Logger logger = Logger.getLogger(ConsumeDirect.class.getName());
    private static final String DIRECT_EXCHANGE_NAME = "direct_logs";

    private void startConsume() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        assert connection != null;
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(DIRECT_EXCHANGE_NAME, "direct");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, DIRECT_EXCHANGE_NAME, ApacheLog.Method.GET.name().toLowerCase());

        logger.info("[*] Waiting for messages for direct exchange. To exit press CTRL+D");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            logger.info(" [x] Received: '\nRouting key: " + delivery.getEnvelope().getRoutingKey() + " ->" + message + "'");
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }

    @Override
    public void run() {
        try {
            startConsume();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, Arrays.toString(ex.getStackTrace()));
        }
    }
}