package ao.jfpack.patterns.observer;

public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new StateObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
