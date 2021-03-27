package 装饰器模式;

/**
 * @author ：ZXF
 * @program: 常见设计模式
 * @description:
 * @date ：2021-03-27 18:39
 */

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
