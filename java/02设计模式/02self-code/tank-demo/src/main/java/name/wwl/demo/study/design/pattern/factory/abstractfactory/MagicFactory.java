package name.wwl.demo.study.design.pattern.factory.abstractfactory;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/20 17:28
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
