package name.wwl.demo.study.tank;

import java.awt.*;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/18 15:44
 */
public class Explode {

    public static int WIDTH = ResourceMgr.explores[0].getWidth();
    public static int HEIGHT = ResourceMgr.explores[0].getHeight();

    private int x,y;

    private Boolean live = true;

    TankFrame tf = null;

    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explores[step++],x,y,null);

        if (step>=ResourceMgr.explores.length){
            tf.explodes.remove(this);
        }
    }
}
