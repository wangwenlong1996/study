package name.wwl.demo.study.tank.factory;

import name.wwl.demo.study.tank.Dir;
import name.wwl.demo.study.tank.Group;
import name.wwl.demo.study.tank.TankFrame;
import name.wwl.demo.study.tank.facade.GameModel;

public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm);

    public abstract BaseExplore createExplore(int x,int y,GameModel gm);

    public abstract BaseBullet createBullet(int x,int y, Dir dir,Group group,GameModel gm);

}
