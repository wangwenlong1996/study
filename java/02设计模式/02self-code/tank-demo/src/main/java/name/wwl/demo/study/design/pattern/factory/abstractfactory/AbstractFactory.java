package name.wwl.demo.study.design.pattern.factory.abstractfactory;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/20 17:17
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}
