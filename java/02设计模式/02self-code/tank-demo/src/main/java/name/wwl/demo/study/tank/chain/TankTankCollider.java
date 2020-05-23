package name.wwl.demo.study.tank.chain;

import name.wwl.demo.study.tank.Tank;

public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank&&o2 instanceof Tank){
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;

            if (t1.getRect().intersects(((Tank) o2).getRect())){

                t1.colliderBack();
                t2.colliderBack();
            }
        }
        return true;
    }
}
