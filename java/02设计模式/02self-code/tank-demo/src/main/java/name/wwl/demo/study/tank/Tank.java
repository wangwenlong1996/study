package name.wwl.demo.study.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x, y;



    private Boolean live = true;

    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;

    private boolean moving = false;

    private TankFrame tf = null;

    Rectangle rect = new Rectangle();

    public static int WIDTH = ResourceMgr.getInstance().goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().goodTankU.getHeight();

    private Group group = Group.BAD;

    private Random random = new Random();


    public Tank(int x, int y, Dir dir,Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        if (this.group == Group.BAD){
            this.moving = true;
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
        if (!live) tf.tanks.remove(this);
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
        int bx = this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
        int by = this.y+Tank.HEIGHT/2 -Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bx,by,this.dir,this.group,tf));

        if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public void die(){
        this.live = false;
    }


}
