package ao.jfpack.aspro.tut.ex;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Greeter extends AbstractActor {

    private final String msg;
    private final ActorRef printerActor;
    private String greeting = "";


    public static Props props(String msg, ActorRef printerActor){
        return Props.create(Greeter.class, () -> new Greeter(msg, printerActor));
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(WhoToGreet.class, wtg -> this.greeting = msg + ", " + wtg.who)
                .match(Greet.class, greet -> printerActor.tell(new Printer.Greeting(greeting), getSelf()))
                .build();
    }





    public Greeter(String msg, ActorRef printerActor){
        this.msg = msg;
        this.printerActor = printerActor;
    }

    public static class WhoToGreet {
        public final String who;
        public WhoToGreet(String who){this.who = who;}
    }

    public static class Greet{
        public Greet(){}
    }
}
