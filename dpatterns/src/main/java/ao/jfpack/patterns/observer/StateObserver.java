package ao.jfpack.patterns.observer;

public class StateObserver implements Observer {

    private Subject subject;

    StateObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Update Observer observing...0j0 -> " + subject.getState());
    }
}
