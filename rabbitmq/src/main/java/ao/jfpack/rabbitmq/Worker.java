package ao.jfpack.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker {

    private static Logger logger = Logger.getLogger(Worker.class.getName());
    private final static String TASK_QUEUE_NAME = "Task_queue";

    public static void main(String[] args) {
        SingleExecutor.getInstance().submit(() -> {
            try {
                startListen();
            } catch (Exception e) {
                logger.info(e.getLocalizedMessage());
            }
        });
    }

    private static void startListen() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

            final Connection connection = factory.newConnection();
            assert connection != null;
            final Channel channel = connection.createChannel();
            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
            System.out.println("[*] Waiting for messages. Press CTRL+C to exit...");
            channel.basicQos(1);
            DeliverCallback deliverCallback = getDeliverCallback(channel);
            channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> {});
    }

    private static DeliverCallback getDeliverCallback(Channel channel) {
        return (consumerTag, delivery) -> {
            String msg = new String(delivery.getBody(), StandardCharsets.UTF_8);
            logger.info("[x] Received: " + msg);
            try {
                doWork(msg);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, e.getMessage());
                Thread.currentThread().interrupt();
            } finally {
                logger.info("[x] Done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };
    }

    private static void doWork(String task) throws InterruptedException {
        for (char c : task.toCharArray()) {
            if (c == '.') Thread.sleep(1000);
        }
    }
}
