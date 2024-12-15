package elhanchir.mohamed;

import elhanchir.mohamed.observer.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        observable.setValue(10);
        observable.setValue(30);
        Observer observer1 = new ObserverImpl1();
        Observer observer2 = new ObserverImpl2();
        observable.addObserver(observer2);
        observable.addObserver(observer1);
        observable.setValue(50);
        observable.setValue(10);
        observable.setValue(30);
        observable.removeObserver(observer1);
        System.out.println("---------------Observer 1 removed--------------");
        observable.setValue(13);

        System.out.println("---------------Anonymous Observer--------------");
        //observateur annonyme càd appartient à une classe qui n'existe pas
        observable.addObserver(new Observer() {
            private final List<Integer> history = new ArrayList<>();
            @Override
            public void update(Observable observable) {
                if (observable instanceof ObservableImpl) {
                    int value = ((ObservableImpl) observable).getValue();
                    System.out.println("************ OBSERVER 3 ************");
                    history.add(value);
                    System.out.println("State AVG: " + history.stream().mapToInt(Integer::intValue).average().orElse(0));
                    System.out.println("************************************");
                }
            }
        });

        observable.setValue(13);
        observable.setValue(12);

        //Observable est une interface fonctionnelle donc on peut utiliser une lambda expression
        observable.addObserver(observable1 -> {
            if (observable1 instanceof ObservableImpl) {
                int value = ((ObservableImpl) observable1).getValue();
                System.out.println("************ OBSERVER 4 ************");
                System.out.println("Value: " + value);
                System.out.println("************************************");
            }
        });

        observable.setValue(13);
        observable.setValue(12);
    }
}