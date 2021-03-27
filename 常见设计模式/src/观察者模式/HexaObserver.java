package 观察者模式;

/**
 * @author ：ZXF
 * @program: 常见设计模式
 * @description:
 * @date ：2021-03-27 18:32
 */

public class HexaObserver extends Observer {
    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
