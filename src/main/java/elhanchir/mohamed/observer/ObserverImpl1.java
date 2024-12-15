package elhanchir.mohamed.observer;

public class ObserverImpl1 implements Observer {
    @Override
    public void update(Observable observable) {
        if(observable instanceof ObservableImpl) {
            int value = ((ObservableImpl) observable).getValue();
            System.out.println("************ OBSERVER 1 ************");
            System.out.println("Value: " + value);
            System.out.println("************************************");
        }

    }
}
