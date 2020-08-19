package ao.jfpack.patterns.observer;

import java.util.HashSet;
import java.util.Set;

public class Subject {

    Set<Observer> observers = new HashSet<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        observers.forEach(Observer::update);
    }
}
