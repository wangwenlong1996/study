package name.wwl.demo.study.tank.factory;

import name.wwl.demo.study.tank.*;
import name.wwl.demo.study.tank.facade.GameModel;

public class DefaultFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return new Tank(x,y,dir,group,gm);
    }

    @Override
    public BaseExplore createExplore(int x, int y, GameModel gm) {
        return new Explode(x,y,gm);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        return new Bullet(x,y,dir,group,gm);
    }
}
