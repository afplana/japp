package ao.jfpack.rabbitmq.pubsub.direct;

import ao.jfpack.rabbitmq.mockob.Book;
import ao.jfpack.rabbitmq.mockob.User;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import static java.util.Arrays.asList;

public class PublisherB {

    private static Logger logger = Logger.getLogger(PublisherB.class.getName());

    public static void main(String[] argv) {
        PublishDirect<Book> bookPublisher = new PublishDirect<>();

        User author1 = new User("Gabriel Garcia Marquez");
        User author2 = new User("Charles Bukowski");

        for (Book book : asList(
                new Book("100 amos de scolded", "some story", author1),
                new Book("North od your eyes ", "other story", author2)
        )) {
            try {
                bookPublisher.publishDirect(book);
            } catch (IOException | TimeoutException ex) {
                logger.info(ex.getLocalizedMessage());
            }
        }
    }
}
