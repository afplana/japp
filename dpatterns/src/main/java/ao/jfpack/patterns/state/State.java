package ao.jfpack.patterns.state;

public interface State {

    void doAction(Context context);
    String current();
}
