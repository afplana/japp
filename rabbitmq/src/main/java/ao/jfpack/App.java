package ao.jfpack;

import ao.jfpack.rabbitmq.Sender;
import ao.jfpack.rabbitmq.SingleExecutor;

import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        Sender sender = new Sender();
        SingleExecutor.getInstance().execute(sender::publish);
    }
}
