package name.wwl.demo.study.tank.chain;

import name.wwl.demo.study.tank.Tank;
import name.wwl.demo.study.tank.factory.Wall;

public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Wall) {
            Tank t = (Tank)o1;
            Wall w = (Wall)o2;


            if(t.rect.intersects(w.rect)) {
                t.colliderBack();

            }

        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            return collide(o2, o1);
        }

        return true;

    }
}
