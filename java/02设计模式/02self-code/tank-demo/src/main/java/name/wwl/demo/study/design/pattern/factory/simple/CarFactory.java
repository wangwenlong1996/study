package name.wwl.demo.study.design.pattern.factory.simple;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/20 17:01
 */
public class CarFactory {
    public Moveable create() {
        System.out.println("a car created!");
        return new Car();
    }
}
