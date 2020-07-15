package name.wwl.demo.study.tank.decorator;

import name.wwl.demo.study.tank.chain.GameObject;
import name.wwl.demo.study.tank.facade.GameModel;

import java.awt.*;

public class RectDecorator extends GoDecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;

        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        System.out.println(go);
        g.drawRect(go.x,go.y ,go.getWidth()+1,go.getHeight()+1);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth()+1;
    }

    @Override
    public int getHeight() {
        return super.go.getHeight()+1;
    }
}
