package ao.jfpack.aspro.tut.hex;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class ActorSupervisionExperiment {
    public static void main(String... args){
        ActorSystem system = ActorSystem.create("supervisionTest");
        ActorRef supervisor = system.actorOf(SupervisorActor.props(), "supervising-actor");
        supervisor.tell("failChild", ActorRef.noSender());
    }
}

class SupervisorActor extends AbstractActor {

    static Props props() {
        return Props.create(SupervisorActor.class, SupervisorActor::new);
    }

    ActorRef child = getContext().actorOf(SupervisedActor.props(), "supervised-actor");

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("failChild", s -> child.tell("fail", getSelf()))
                .build();
    }
}

class SupervisedActor extends AbstractActor {

    static Props props() {
        return Props.create(SupervisedActor.class, SupervisedActor::new);
    }

    @Override
    public void preStart() {
        System.out.println("Supervised actor start");
    }

    @Override
    public void postStop() {
        System.out.println("Supervised actor stop");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("fail", s -> {
            System.out.println("supervised actor fails now");
            throw new Exception("Supervised Failed!");
        })
                .build();
    }
}