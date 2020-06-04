package name.wwl.demo.study.tank.factory;

import name.wwl.demo.study.tank.*;
import name.wwl.demo.study.tank.facade.GameModel;

public class RectFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group) {
        return new RectTank(x,y,dir,group);
    }

    @Override
    public BaseExplore createExplore(int x, int y) {
        return new RectExplode(x,y);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group) {
        return new RectBullet(x,y,dir,group);
    }
}
