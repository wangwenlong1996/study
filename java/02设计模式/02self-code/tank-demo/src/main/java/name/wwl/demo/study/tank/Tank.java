package name.wwl.demo.study.tank;

import name.wwl.demo.study.tank.facade.GameModel;
import name.wwl.demo.study.tank.factory.BaseTank;
import name.wwl.demo.study.tank.observe.TankFireEvent;
import name.wwl.demo.study.tank.observe.TankFireHandler;
import name.wwl.demo.study.tank.observe.TankFireObserver;
import name.wwl.demo.study.tank.singleton.ResourceMgr;
import name.wwl.demo.study.tank.strategy.FireStrategy;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Random;

public class Tank extends BaseTank {
    int x, y;



    private Boolean live = true;


    private static final int SPEED = 10;

    private boolean moving = false;






    public static int WIDTH = ResourceMgr.getInstance().goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().goodTankU.getHeight();


    private Random random = new Random();

    FireStrategy fs;




    public Tank(int x, int y, Dir dir,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        if (this.group == Group.BAD){
            this.moving = true;
        }

        if (this.group == Group.GOOD){
//            String goodFsName = (String) PropertyMgr.get("decoratorFS");
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

        gm.add(this);


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

        switch (dir){
            case LEFT:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.getInstance().goodTankL:ResourceMgr.getInstance().badTankL,x,y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.getInstance().goodTankU:ResourceMgr.getInstance().badTankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.getInstance().goodTankR:ResourceMgr.getInstance().badTankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.getInstance().goodTankD:ResourceMgr.getInstance().badTankD,x,y,null);
                break;
        }

        move();

        if (this.group == Group.BAD&&random.nextInt(100)>95) this.fire();

        if (this.group == Group.BAD&&random.nextInt(100)>95) this.randomDir();

        boundCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private void boundCheck(){
        if (this.x<2) x = 2;
        if (this.y<28) y = 28;
        if (this.x>TankFrame.GAME_WIDTH-Tank.WIDTH -2) x = TankFrame.GAME_WIDTH-Tank.WIDTH-2;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT -2 ) y = TankFrame.GAME_HEIGHT -Tank.HEIGHT -2;
    }

    private void randomDir(){
        this.dir = Dir.values()[random.nextInt(4)];
    }


    private void move() {

        if(!moving) return ;

        beforeX =x;
        beforeY = y;


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
//        this.die();
//        randomDir();
    }


    public void die(){
        this.live = false;
    }


    private java.util.List<TankFireObserver> fireObservers = Arrays.asList(new TankFireHandler());

    public void handleFireKey(){
        TankFireEvent event = new TankFireEvent(this);

        for (TankFireObserver o: fireObservers){
            o.actionOnFire(event);
        }
    }

}
