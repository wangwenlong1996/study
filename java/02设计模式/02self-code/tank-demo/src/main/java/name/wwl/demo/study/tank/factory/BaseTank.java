package name.wwl.demo.study.tank.factory;

import name.wwl.demo.study.tank.Dir;
import name.wwl.demo.study.tank.Group;
import name.wwl.demo.study.tank.TankFrame;
import name.wwl.demo.study.tank.chain.GameObject;
import name.wwl.demo.study.tank.facade.GameModel;

import java.awt.*;

public abstract class BaseTank extends GameObject {


    public int beforeX,beforeY;

    public Group group = Group.BAD;

    public Rectangle rect = new Rectangle();

    public Rectangle getRect() {
        return rect;
    }

    public Dir getDir() {
        return dir;
    }


    public Dir dir = Dir.DOWN;

    public GameModel getGm() {
        return gm;
    }

    public void setGm(GameModel gm) {
        this.gm = gm;
    }

    public GameModel gm = null;


    public Group getGroup(){
        return this.group;
    }

    public abstract void die();

    public abstract int getX();

    public abstract int getY();

}
