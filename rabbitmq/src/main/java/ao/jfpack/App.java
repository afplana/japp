package ao.jfpack;

import ao.jfpack.rabbitmq.pubsub.direct.ConsumeDirectBook;

import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        ConsumeDirectBook.books.forEach(book -> logger.info("-> " + book.author + " " + book.synopses));
    }
}
