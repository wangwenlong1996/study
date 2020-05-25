package name.wwl.demo.study.tank;

import name.wwl.demo.study.tank.chain.GameObject;
import name.wwl.demo.study.tank.facade.GameModel;
import name.wwl.demo.study.tank.factory.BaseExplore;
import name.wwl.demo.study.tank.singleton.ResourceMgr;

import java.awt.*;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/18 15:44
 */
public class Explode extends BaseExplore{

    public static int WIDTH = ResourceMgr.getInstance().explores[0].getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().explores[0].getHeight();

    private int x,y;

    private Boolean live = true;

    GameModel gm = GameModel.getInstance();

    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        GameModel.getInstance().add(this);
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(ResourceMgr.getInstance().explores[step++],x,y,null);

        if (step>=ResourceMgr.getInstance().explores.length){
            gm.remove(this);
        }
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}
