package 工厂模式;

/**
 * @author ：ZXF
 * @program: 常见设计模式
 * @description:
 * @date ：2021-03-27 18:08
 */

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
