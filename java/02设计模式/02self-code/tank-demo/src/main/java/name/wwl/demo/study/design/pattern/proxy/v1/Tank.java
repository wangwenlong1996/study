package name.wwl.demo.study.design.pattern.proxy.v1;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 */
public class Tank implements Movable{

    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

interface Movable{
    void move();
}