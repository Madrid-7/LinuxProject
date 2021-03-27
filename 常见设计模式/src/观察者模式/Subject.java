package 观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：ZXF
 * @program: 常见设计模式
 * @description:
 * @date ：2021-03-27 18:29
 */

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    public void attach(Observer observer) {
        observers.add(observer);
    }
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
