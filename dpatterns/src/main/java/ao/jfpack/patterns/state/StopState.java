package ao.jfpack.patterns.state;

public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("System stopping...");
        context.setState(this);
    }

    public String current(){
        return "Stopped State";
    }
}
