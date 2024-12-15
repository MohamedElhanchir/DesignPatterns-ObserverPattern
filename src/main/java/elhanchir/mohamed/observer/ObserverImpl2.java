package elhanchir.mohamed.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverImpl2 implements Observer {

    private List<Integer> history=new ArrayList<>();

    @Override
    public void update(int value) {
        System.out.println("************ OBSERVER 2 ************");
        history.add(value);
        System.out.println("State AVG: " + history.stream().mapToInt(Integer::intValue).average().orElse(0));
        System.out.println("************************************");
    }
}
