package name.wwl.demo.study.design.pattern.factory.abstractfactory;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/20 17:18
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
