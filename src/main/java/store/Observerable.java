package store;

import java.util.ArrayList;
import java.util.List;

public class Observerable {

    private List<Observer> observers;

    public Observerable() {
        observers = new ArrayList<>();
    }

    public boolean addObserver(Observer newObs){
        observers.add(newObs);
        return true;
    }

    public boolean removeObserver(Observer obs){
        observers.remove(obs);
        return true;
    }

    public void notifyAllObservers() {
        for (Observer obs: observers){
            obs.update("notification");
        }
    }
}
