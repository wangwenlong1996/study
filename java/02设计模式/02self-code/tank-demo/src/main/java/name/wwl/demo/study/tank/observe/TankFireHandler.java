package name.wwl.demo.study.tank.observe;

import name.wwl.demo.study.tank.Tank;

public class TankFireHandler implements TankFireObserver {
    @Override
    public void actionOnFire(TankFireEvent event) {
        Tank t = event.getSource();

        t.fire();
    }
}
