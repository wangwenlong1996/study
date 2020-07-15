package name.wwl.demo.study.tank.factory;

import name.wwl.demo.study.tank.Dir;
import name.wwl.demo.study.tank.Group;
import name.wwl.demo.study.tank.TankFrame;
import name.wwl.demo.study.tank.facade.GameModel;

public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group);

    public abstract BaseExplore createExplore(int x,int y);

    public abstract BaseBullet createBullet(int x,int y, Dir dir,Group group);

}
