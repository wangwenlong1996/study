package name.wwl.demo.study.design.pattern.factory.abstractfactory;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/20 17:25
 */
public class MagicStick extends Weapon{
    @Override
    void shoot() {
        System.out.println("魔法棒攻击");
    }
}
