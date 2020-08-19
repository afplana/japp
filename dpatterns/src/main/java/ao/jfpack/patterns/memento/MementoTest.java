package ao.jfpack.patterns.memento;

public class MementoTest {

    public static void main (String[] args) {
        Originator originator = new Originator();
        Operator operator = new Operator();

        originator.state = "State #1";
        originator.state = "State #2";
        operator.save(originator.saveState());

        originator.state = "State #3";
        operator.save(originator.saveState());

        originator.state = "State #4";
        System.out.println("Current State: " + originator.state);

        originator.restoreStateTo(operator.get());
        System.out.println("Previous State: " + originator.state);
        originator.restoreStateTo(operator.get());
        System.out.println("State before previous: " + originator.state);
    }
}
