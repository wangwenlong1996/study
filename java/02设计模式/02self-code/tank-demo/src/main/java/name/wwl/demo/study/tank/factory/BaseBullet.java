package name.wwl.demo.study.tank.factory;

import name.wwl.demo.study.tank.Group;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank tank);

}
