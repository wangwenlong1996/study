package name.wwl.demo.study.tank.factory;

import name.wwl.demo.study.tank.*;
import name.wwl.demo.study.tank.facade.GameModel;
import name.wwl.demo.study.tank.singleton.ResourceMgr;

import java.awt.*;

public class RectBullet extends BaseBullet {
    private static final int SPEED = 10;
    public static int WIDTH = ResourceMgr.getInstance().bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().bulletD.getHeight();

    Rectangle rect = new Rectangle();

    GameModel gm = null;
    private int x, y;
    private Dir dir;
    private boolean live=true;

    private Group group = Group.BAD;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public RectBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        gm.add(this);
    }

    public void  paint(Graphics g){
        if(!live) {
            gm.remove(this);
        }

        Color c =g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,WIDTH,HEIGHT);
        g.setColor(c);

//        switch (dir) {
//            case LEFT:
//                g.drawImage(ResourceMgr.getInstance().bulletL,x,y,null);
//                break;
//            case UP:
//                g.drawImage(ResourceMgr.getInstance().bulletU,x,y,null);
//                break;
//            case RIGHT:
//                g.drawImage(ResourceMgr.getInstance().bulletR,x,y,null);
//                break;
//            case DOWN:
//                g.drawImage(ResourceMgr.getInstance().bulletD,x,y,null);
//                break;
//        }

        move();
        rect.x = this.x;
        rect.y= this.y;
    }

    private void move() {
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

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) this.die();

    }

    @Override
    public boolean collideWith(BaseTank tank){
        if (this.group ==tank.getGroup()) return false;
        if (rect.intersects(tank.rect)){
            this.die();
            tank.die();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            gm.add(gm.gf.createExplore(eX,eY,gm));
            return true;
        }

        return false;
    }

    private void die(){
        this.live=false;
    }
}
