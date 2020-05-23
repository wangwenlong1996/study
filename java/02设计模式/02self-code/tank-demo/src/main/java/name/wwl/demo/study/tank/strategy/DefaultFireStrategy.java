package name.wwl.demo.study.tank.strategy;

import name.wwl.demo.study.tank.Audio;
import name.wwl.demo.study.tank.Bullet;
import name.wwl.demo.study.tank.Group;
import name.wwl.demo.study.tank.Tank;
import name.wwl.demo.study.tank.factory.BaseTank;

public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(BaseTank t) {
        int bx = t.getX()+Tank.WIDTH/2- Bullet.WIDTH/2;
        int by = t.getY()+Tank.HEIGHT/2 -Bullet.HEIGHT/2;

       t.getGm().gf.createBullet(bx,by,t.getDir(),t.getGroup(),t.getGm());

        if(t.getGroup() == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();

    }
}
