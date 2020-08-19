package ao.jfpack.patterns.memento;

import java.util.Stack;

public class Operator {
    private Stack<Memento> mementos = new Stack<>();

    public void save(Memento state){
        mementos.push(state);
    }

    public Memento get(){
        return mementos.pop();
    }
}
