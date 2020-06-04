package name.wwl.demo.study.tank.strategy;

import name.wwl.demo.study.tank.*;
import name.wwl.demo.study.tank.decorator.RectDecorator;
import name.wwl.demo.study.tank.decorator.TailDecorator;
import name.wwl.demo.study.tank.facade.GameModel;
import name.wwl.demo.study.tank.factory.BaseTank;

public class DecoratorFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank t) {
        int bx = t.getX()+ Tank.WIDTH/2- Bullet.WIDTH/2;
        int by = t.getY()+Tank.HEIGHT/2 -Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();

        for (Dir dir:dirs){
            System.out.println(dir);
//            Bullet bullet = new Bullet(bx,by,t.dir,t.getGroup());
//            GameModel.getInstance().remove(bullet);
            GameModel.getInstance().add(new RectDecorator(new TailDecorator(new Bullet(bx,by,t.dir,t.getGroup()))));


        }
        if(t.getGroup() == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();

    }
}
