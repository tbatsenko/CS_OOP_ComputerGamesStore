package store;

import java.util.ArrayList;
import java.util.List;

public class Observerable {

    private List<Observer> observers;

    Observerable() {
        observers = new ArrayList<>();
    }

    public boolean addObserver(Observer newObserver){
        if (newObserver != null) {
            observers.add(newObserver);
            return true;
        }
        return false;
    }

    public boolean removeObserver(Observer observerToRemove){
        if (observerToRemove != null) {
            observers.remove(observerToRemove);
            return true;
        }
        return false;
    }

    public void notifyAllObservers() {
        for (Observer obs: observers){
            obs.update("notification to Observers");
        }
    }
}
