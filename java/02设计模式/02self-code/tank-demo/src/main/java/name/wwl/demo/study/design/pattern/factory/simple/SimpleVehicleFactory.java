package name.wwl.demo.study.design.pattern.factory.simple;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/20 17:03
 */
public class SimpleVehicleFactory {

    public Car createCar(){
        return new Car();
    }

    public Broom createBroom() {
        return new Broom();
    }
}
