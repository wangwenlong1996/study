package name.wwl.demo.study.design.pattern.proxy.v2;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 */
public class Tank implements Movable {

    @Override
    public void move() {
        long start = System.currentTimeMillis();

        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Movable{
    void move();
}