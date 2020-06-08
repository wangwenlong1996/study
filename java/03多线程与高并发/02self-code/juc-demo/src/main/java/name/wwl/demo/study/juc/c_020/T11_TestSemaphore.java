package name.wwl.demo.study.juc.c_020;

import java.util.concurrent.Semaphore;

public class T11_TestSemaphore {

    public static void main(String[] args) {
        Semaphore s = new Semaphore(1,true);

        new Thread(() ->{
            try {
                s.acquire();

                System.out.println("T1 running start...");
                Thread.sleep(200);
                System.out.println("T1 running end...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();

                System.out.println("T2 running start...");
                Thread.sleep(200);
                System.out.println("T2 running stop...");

                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
