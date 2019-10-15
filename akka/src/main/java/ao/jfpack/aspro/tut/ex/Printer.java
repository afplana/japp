package ao.jfpack.aspro.tut.ex;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Printer extends AbstractActor {

    private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    public Printer(){}

    public static Props props(){
        return Props.create(Printer.class, Printer::new);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Greeting.class, greeting -> log.info(greeting.msg))
                .build();
    }



    public static class Greeting {
        public final String msg;
        public Greeting(String msg){
            this.msg = msg;
        }
    }
}
