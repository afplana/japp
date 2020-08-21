package ao.jfpack.patterns.state;

public class StateTest {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().current());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().current());
    }
}
