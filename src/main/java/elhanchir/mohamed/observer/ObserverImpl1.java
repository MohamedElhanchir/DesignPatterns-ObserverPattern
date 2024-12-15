package elhanchir.mohamed.observer;

public class ObserverImpl1 implements Observer {
    @Override
    public void update(int value) {
        System.out.println("************ OBSERVER 1 ************");
        System.out.println("Value: " + value);
        System.out.println("************************************");
    }
}
