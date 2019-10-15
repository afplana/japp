package ao.jfpack;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import ao.jfpack.aspro.tut.ex.Greeter;
import ao.jfpack.aspro.tut.ex.Printer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    static ActorSystem system;

    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
    }

    @AfterClass
    public static void teardown() {
        TestKit.shutdownActorSystem(system);
        system = null;
    }

    @Test
    public void shouldAnswerWithTrue() {
        final TestKit testKit = new TestKit(system);
        final ActorRef actorRef = system.actorOf(Greeter.props("Hello", testKit.getRef()));
        actorRef.tell(new Greeter.WhoToGreet("Akka"), ActorRef.noSender());
        actorRef.tell(new Greeter.Greet(), ActorRef.noSender());
        Printer.Greeting greeting = testKit.expectMsgClass(Printer.Greeting.class);
        assertEquals("Hello, Akka", greeting.msg);
    }
}
