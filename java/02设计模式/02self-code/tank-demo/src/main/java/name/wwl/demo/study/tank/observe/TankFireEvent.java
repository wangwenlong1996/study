package name.wwl.demo.study.tank.observe;

import name.wwl.demo.study.tank.Tank;

public class TankFireEvent {

    Tank tank;

    public Tank getSource(){
        return tank;
    }

    public TankFireEvent(Tank tank){
        this.tank = tank;
    }
}
