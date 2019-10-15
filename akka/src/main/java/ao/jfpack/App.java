package ao.jfpack;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import ao.jfpack.aspro.Greeter;
import ao.jfpack.aspro.Printer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {

    private static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("firstakka");
        try {
            final ActorRef printerActor = system.actorOf(Printer.props(), "printerActor");
            final ActorRef howdyGreeter = system.actorOf(Greeter.props("Howdy", printerActor), "howdyGreeter");
            final ActorRef helloGreeter = system.actorOf(Greeter.props("Hello", printerActor), "helloGreeter");
            final ActorRef goodDayGreeter = system.actorOf(Greeter.props("Good Day", printerActor), "goodDayGreeter");

            howdyGreeter.tell(new Greeter.WhoToGreet("Akka"), ActorRef.noSender());
            howdyGreeter.tell(new Greeter.Greet(), ActorRef.noSender());


            howdyGreeter.tell(new Greeter.WhoToGreet("LightBend"), ActorRef.noSender());
            howdyGreeter.tell(new Greeter.Greet(), ActorRef.noSender());

            helloGreeter.tell(new Greeter.WhoToGreet("Java"), ActorRef.noSender());
            helloGreeter.tell(new Greeter.Greet(), ActorRef.noSender());

            goodDayGreeter.tell(new Greeter.WhoToGreet("Play"), ActorRef.noSender());
            goodDayGreeter.tell(new Greeter.Greet(), ActorRef.noSender());

            logger.info("[!] Print ENTER to exit.");
            System.in.read();
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getLocalizedMessage());
        } finally {
            system.terminate();
        }
    }
}
