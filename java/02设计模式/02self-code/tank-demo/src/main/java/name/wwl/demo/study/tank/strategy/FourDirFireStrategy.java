package name.wwl.demo.study.tank.strategy;

import name.wwl.demo.study.tank.*;
import name.wwl.demo.study.tank.factory.BaseTank;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank t) {
        int bx = t.getX()+Tank.WIDTH/2- Bullet.WIDTH/2;
        int by = t.getY()+Tank.HEIGHT/2 -Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();

        for (Dir dir:dirs){
            t.getGm().gf.createBullet(bx,by,dir,t.getGroup(),t.getGm());


        }
        if(t.getGroup() == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();

    }
}
