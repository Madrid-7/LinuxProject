package 观察者模式;

/**
 * @author ：ZXF
 * @program: 常见设计模式
 * @description:
 * @date ：2021-03-27 18:30
 */

public abstract class Observer {

    protected Subject subject;

    public abstract void update();

}
