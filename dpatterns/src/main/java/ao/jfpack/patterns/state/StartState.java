package ao.jfpack.patterns.state;

public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("System starting...");
        context.setState(this);
    }

    public String current(){
        return "Started State";
    }
}
