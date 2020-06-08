package name.wwl.demo.study.juc.c_020;

import java.util.concurrent.TimeUnit;
/**
 * reentrantlock用于替代synchronized
 * 本例中由于m1锁定this,只有m1执行完毕的时候,m2才能执行
 * 这里是复习synchronized最原始的语义
 * @author mashibing
 */
public class T01_ReentrantLock1 {

    synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i);

            if (i==2) m2();
        }
    }

    synchronized private void m2() {
        System.out.println("m2 ...");
    }

    public static void main(String[] args) {
        T01_ReentrantLock1 r1 = new T01_ReentrantLock1();

        new Thread(r1::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r1::m2).start();
    }
}
