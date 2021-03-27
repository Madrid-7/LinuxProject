package 单例模式;

/**
 * @author ：ZXF
 * @program: 常见设计模式
 * @description: 懒汉式, 线程安全
 * @date ：2021-03-27 17:45
 */

public class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
