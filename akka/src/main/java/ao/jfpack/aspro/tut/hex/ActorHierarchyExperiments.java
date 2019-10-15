package ao.jfpack.aspro.tut.hex;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.io.IOException;

class PrintMyActorRefActor extends AbstractActor {

    static Props props() {
        return Props.create(PrintMyActorRefActor.class, PrintMyActorRefActor::new);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("printit", s -> {
                    ActorRef secondRef = getContext().actorOf(Props.empty(), "second-actor");
                    System.out.println("Second: " + secondRef);
                }).build();
    }
}

public class ActorHierarchyExperiments {
    public static void main(String... argv) throws IOException {
        ActorSystem system = ActorSystem.create("testSystem");
        try {
            ActorRef firstRef = system.actorOf(PrintMyActorRefActor.props(), "first-actor");
            System.out.println("First: " + firstRef);
            firstRef.tell("printit", ActorRef.noSender());

            System.out.println("[!] Press ENTER to exit.");
            System.in.read();
        } finally {
            system.terminate();
        }
    }
}
