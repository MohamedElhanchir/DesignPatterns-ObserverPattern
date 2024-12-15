package elhanchir.mohamed.observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable {

    private int value;
    private List<Observer> observers= new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(value);
        }
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }

    public int getValue() {
        return value;
    }
}
