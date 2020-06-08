package name.wwl.demo.study.juc.c_020;

import java.util.concurrent.CountDownLatch;

public class T06_TestCountDownLatch {

    private static void usingCountDownLatch() {
        Thread[] threads = new Thread[10000];

        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;

                for (int j = 0; j < 1000000; j++) {
                    result += j;
                }
                latch.countDown();
            });
        }

            for (int j = 0; j < threads.length; j++) {
                threads[j].start();
            }

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end latch");


    }


    private static void usingJoin() {
        Thread[] threads = new Thread[10000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;

                for (int j = 0; j < 1000000; j++) result += j;
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end Join");
    }

    public static void main(String[] args) {

        long start= System.currentTimeMillis();
        usingCountDownLatch();
        long end = System.currentTimeMillis();

        System.out.println("Atomic: " +  " time " + (end-start));

        long start1= System.currentTimeMillis();
        usingJoin();
        long end1 = System.currentTimeMillis();
        System.out.println("Atomic: " +" time " + (end1-start1));

    }

}
