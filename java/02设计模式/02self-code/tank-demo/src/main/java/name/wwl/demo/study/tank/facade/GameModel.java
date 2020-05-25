package name.wwl.demo.study.tank.facade;

import name.wwl.demo.study.tank.Dir;
import name.wwl.demo.study.tank.Group;
import name.wwl.demo.study.tank.PropertyMgr;
import name.wwl.demo.study.tank.Tank;
import name.wwl.demo.study.tank.chain.ColliderChain;
import name.wwl.demo.study.tank.chain.GameObject;
import name.wwl.demo.study.tank.factory.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {


    Tank myTank = null;

    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }
    public static GameModel getInstance(){
        return INSTANCE;
    }

    public List<GameObject> objects = new ArrayList<>();

    public GameFactory gf = new DefaultFactory();

    ColliderChain colliderChain = new ColliderChain();

    private void init(){
        myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);

        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for(int i=0; i<initTankCount; i++) {
            this.gf.createTank(50 + i*160, 50, Dir.DOWN,Group.BAD);
        }

        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));


    }

     private  GameModel() {


    }

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
//        g.drawString("敌人的数量:" + tanks.size(), 10, 80);
//        g.drawString("爆炸的数量:" + explodes.size(), 10, 100);
        g.setColor(c);


        myTank.paint(g);



        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }


        for (int i=0;i< objects.size();i++){
            for (int j = i+1;j<objects.size();j++){
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);

                colliderChain.collide(o1,o2);
            }
        }
    }


        public Tank getMyTank () {
            return myTank;


        }
}