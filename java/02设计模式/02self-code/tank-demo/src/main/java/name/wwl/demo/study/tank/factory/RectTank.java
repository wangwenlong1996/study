package name.wwl.demo.study.tank.factory;

import name.wwl.demo.study.tank.Dir;
import name.wwl.demo.study.tank.Group;
import name.wwl.demo.study.tank.PropertyMgr;
import name.wwl.demo.study.tank.TankFrame;
import name.wwl.demo.study.tank.facade.GameModel;
import name.wwl.demo.study.tank.singleton.ResourceMgr;
import name.wwl.demo.study.tank.strategy.FireStrategy;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class RectTank extends BaseTank {
    int x, y;



    private Boolean live = true;

    private static final int SPEED = 10;

    private boolean moving = false;



//    Rectangle rect = new Rectangle();

    public static int WIDTH = ResourceMgr.getInstance().goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().goodTankU.getHeight();

//    private Group group = Group.BAD;

    private Random random = new Random();

    FireStrategy fs;

    public RectTank(int x, int y, Dir dir, Group group, GameModel gm) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;
        if (this.group == Group.BAD){
            this.moving = true;
        }

        if (this.group == Group.GOOD){
            String goodFsName = (String) PropertyMgr.get("goodFS");

            try {
                fs = (FireStrategy)Class.forName(goodFsName).getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            String badFsName = (String) PropertyMgr.get("badFS");
            try {
                fs = (FireStrategy)Class.forName(badFsName).getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

    }
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if (!live) gm.remove(this);
        // TODO Auto-generated method stub

        Color c = g.getColor();
        g.setColor(group == Group.GOOD ? Color.RED : Color.BLUE);
        g.fillRect(x, y, 40, 40);
        g.setColor(c);

//        switch (dir){
//            case LEFT:
//                g.drawImage(this.group == Group.GOOD? ResourceMgr.getInstance().goodTankL:ResourceMgr.getInstance().badTankL,x,y,null);
//                break;
//            case UP:
//                g.drawImage(this.group == Group.GOOD? ResourceMgr.getInstance().goodTankU:ResourceMgr.getInstance().badTankU,x,y,null);
//                break;
//            case RIGHT:
//                g.drawImage(this.group == Group.GOOD? ResourceMgr.getInstance().goodTankR:ResourceMgr.getInstance().badTankR,x,y,null);
//                break;
//            case DOWN:
//                g.drawImage(this.group == Group.GOOD? ResourceMgr.getInstance().goodTankD:ResourceMgr.getInstance().badTankD,x,y,null);
//                break;
//        }

        move();

        if (this.group == Group.BAD&&random.nextInt(100)>95) this.fire();

        if (this.group == Group.BAD&&random.nextInt(100)>95) this.randomDir();

        boundCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundCheck(){
        if (this.x<2) x = 2;
        if (this.y<28) y = 28;
        if (this.x>TankFrame.GAME_WIDTH- RectTank.WIDTH -2) x = TankFrame.GAME_WIDTH- RectTank.WIDTH-2;
        if (this.y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT -2 ) y = TankFrame.GAME_HEIGHT - RectTank.HEIGHT -2;
    }

    private void randomDir(){
        this.dir = Dir.values()[random.nextInt(4)];
    }


    private void move() {

        if(!moving) return ;

        beforeX =x;
        beforeY =y;

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }

    public void fire(){
//        int bx = this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
//        int by = this.y+Tank.HEIGHT/2 - Bullet.HEIGHT/2;
//        int bx = this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
//        int by = this.y+Tank.HEIGHT/2 -Bullet.HEIGHT/2;
//        tf.bullets.add(new Bullet(bx,by,this.dir,this.group,tf));
//
//        if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
        fs.fire(this);

    }

    public void colliderBack(){
        x = beforeX;
        y = beforeY;
        randomDir();
    }


    public void die(){
        this.live = false;
    }


}
