package 单例模式;

/**
 * @author ：ZXF
 * @program: 常见设计模式
 * @description: 饿汉式, 双检锁/双重校验锁 + volatile关键字
 * @date ：2021-03-27 17:54
 */

public class Singleton3 {
    private volatile static Singleton3 instance = null;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
