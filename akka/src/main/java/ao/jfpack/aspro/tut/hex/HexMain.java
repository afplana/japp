package ao.jfpack.aspro.tut.hex;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.io.IOException;

public class HexMain {
    public static void main(String... args) throws IOException {
        ActorSystem system = ActorSystem.create("startStopTestSystem");
        try {
            ActorRef first = system.actorOf(StartStopActors.props(), "first");

            first.tell("stop", ActorRef.noSender());

            System.out.println("[!] Press ENTER to terminate the program");
            System.in.read();
        } finally {
            system.terminate();
        }


    }
}

class StartStopActors extends AbstractActor {

    static Props props() {
        return Props.create(StartStopActors.class, StartStopActors::new);
    }

    @Override
    public void preStart() {
        System.out.println("first started");
        getContext().actorOf(StartStopActors2.props(), "second");
    }

    @Override
    public void postStop() {
        System.out.println("first stopped");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("stop", s -> getContext().stop(self()))
                .build();
    }
}

class StartStopActors2 extends AbstractActor {

    static Props props() {
        return Props.create(StartStopActors2.class, StartStopActors2::new);
    }

    @Override
    public void preStart() {
        System.out.println("second started");
    }

    @Override
    public void postStop() {
        System.out.println("second stopped");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().build();
    }
}
