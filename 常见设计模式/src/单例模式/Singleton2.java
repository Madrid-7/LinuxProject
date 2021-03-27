package 单例模式;

/**
 * @author ：ZXF
 * @program: 常见设计模式
 * @description: 饿汉式, 线程安全
 * @date ：2021-03-27 17:50
 */

public class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2() {
    }

    public synchronized static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
