package name.wwl.demo.study.tank;

import java.awt.*;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/15 9:04
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tk = new TankFrame();


        while(true) {
            Thread.sleep(50);
            tk.repaint();
        }
    }
}
