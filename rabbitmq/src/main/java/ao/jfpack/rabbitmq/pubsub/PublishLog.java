package ao.jfpack.rabbitmq.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class PublishLog {

    private static final Logger logger = Logger.getLogger(PublishLog.class.getName());
    private static final String EXCHANGE_NAME = "logs";
    private static final String DIRECT_EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        String msg = (args.length < 1) ? "info: Log Report to short" : String.join(" ", args);

        if (args[0].equalsIgnoreCase("warning") ||
                args[0].equalsIgnoreCase("info") ||
                args[0].equalsIgnoreCase("error"))

            publishExchangeDirect(args, connection);

        publishExchangeFanout(args, connection);

    }

    private static void publishExchangeDirect(String[] args, Connection connection) throws IOException {
        assert connection != null;

        Channel channel = connection.createChannel();
        channel.exchangeDeclare(DIRECT_EXCHANGE_NAME, "direct");

        String msg = String.join(" ", args);

        channel.basicPublish(DIRECT_EXCHANGE_NAME, args[0], MessageProperties.BASIC, msg.getBytes(StandardCharsets.UTF_8));
        logger.info("[X] Message sent: '" + msg + "'");
    }

    private static void publishExchangeFanout(String[] args, Connection connection) throws IOException {
        assert connection != null;
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        String msg = (args.length < 1) ? "info: Log Report to short" : String.join(" ", args);


        channel.basicPublish(EXCHANGE_NAME, "", MessageProperties.BASIC, msg.getBytes(StandardCharsets.UTF_8));
        logger.info("[X] Message sent: '" + msg + "'");
    }
}
