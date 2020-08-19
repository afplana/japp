package ao.jfpack.patterns.memento;

public class Originator {

    String state;

    public Memento saveState(){
        return new Memento(this.state);
    }

    public void restoreStateTo(Memento memento){
        state = memento.getState();
    }
}
