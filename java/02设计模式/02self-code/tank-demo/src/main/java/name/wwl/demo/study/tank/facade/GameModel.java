package name.wwl.demo.study.tank.facade;

import name.wwl.demo.study.tank.Dir;
import name.wwl.demo.study.tank.Group;
import name.wwl.demo.study.tank.PropertyMgr;
import name.wwl.demo.study.tank.Tank;
import name.wwl.demo.study.tank.factory.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {


    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD,this);
    public List<BaseBullet> bullets = new ArrayList<>();
    public List<BaseTank> tanks = new ArrayList<>();
    public List<BaseExplore> explodes = new ArrayList<>();

    public GameFactory gf = new DefaultFactory();


    public GameModel() {

        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for(int i=0; i<initTankCount; i++) {
           tanks.add(this.gf.createTank(50 + i*80, 200, Dir.DOWN,Group.BAD, this));
        }
    }

    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.drawString("敌人的数量:" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量:" + explodes.size(), 10, 100);
        g.setColor(c);


        myTank.paint(g);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }
    }


        public Tank getMyTank () {
            return myTank;


        }
}