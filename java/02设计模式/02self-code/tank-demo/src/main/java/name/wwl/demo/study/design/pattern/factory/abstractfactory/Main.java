package name.wwl.demo.study.design.pattern.factory.abstractfactory;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/20 17:20
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory f = new ModernFactory();
        Vehicle vehicle = f.createVehicle();
        vehicle.go();
        Weapon w = f.createWeapon();
        w.shoot();
        Food b = f.createFood();
        b.printName();

        AbstractFactory f1 = new MagicFactory();
        Vehicle vehicle1 = f1.createVehicle();
        vehicle1.go();
        Weapon w1 = f1.createWeapon();
        w1.shoot();
        Food b1 = f1.createFood();
        b1.printName();
    }


}

