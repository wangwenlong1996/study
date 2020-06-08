package name.wwl.demo.study.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class T07_TestCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(20, ()->System.out.println("人满"));

        for (int i = 0; i < 100; i++) {
            new Thread(()->{

                    try {
                        barrier.await();
                    } catch (BrokenBarrierException | InterruptedException e) {
                        e.printStackTrace();
                    }

            }).start();
        }
    }





}
