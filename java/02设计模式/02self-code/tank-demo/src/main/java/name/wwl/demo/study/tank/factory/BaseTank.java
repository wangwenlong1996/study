package name.wwl.demo.study.tank.factory;

import name.wwl.demo.study.tank.Dir;
import name.wwl.demo.study.tank.Group;
import name.wwl.demo.study.tank.TankFrame;

import java.awt.*;

public abstract class BaseTank {



    public Group group = Group.BAD;

    public Rectangle rect = new Rectangle();

    public Rectangle getRect() {
        return rect;
    }

    public Dir getDir() {
        return dir;
    }

    public TankFrame getTf() {
        return tf;
    }

    public Dir dir = Dir.DOWN;

    public TankFrame tf = null;

    public abstract void paint(Graphics g);

    public Group getGroup(){
        return this.group;
    }

    public abstract void die();

    public abstract int getX();

    public abstract int getY();

}
