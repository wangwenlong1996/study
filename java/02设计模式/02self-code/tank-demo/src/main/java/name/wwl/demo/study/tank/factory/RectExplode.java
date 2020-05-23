package name.wwl.demo.study.tank.factory;

import name.wwl.demo.study.tank.Audio;
import name.wwl.demo.study.tank.TankFrame;
import name.wwl.demo.study.tank.singleton.ResourceMgr;

import java.awt.*;

public class RectExplode extends BaseExplore {
    public static int WIDTH = ResourceMgr.getInstance().explores[0].getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().explores[0].getHeight();

    private int x,y;


    TankFrame tf = null;

    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g){
        //g.drawImage(ResourceMgr.getInstance().explores[step++],x,y,null);

        Color c =  g.getColor();
        g.setColor(Color.red);
        g.fillRect(x,y,2*step,2*step);

        step ++;
        if (step>=ResourceMgr.getInstance().explores.length){
            tf.explodes.remove(this);
        }

        g.setColor(c);
    }
}
