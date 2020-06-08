package name.wwl.demo.study.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;


public class T08_Semphore {

    volatile List lists = new ArrayList();


    static Thread t1 = null, t2 = null;


    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {

        T08_Semphore c = new T08_Semphore();

        Semaphore semaphore = new Semaphore(1);

        t2 = new Thread(()->{
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("t2 结束");
            semaphore.release();

        },"t2");



        t1 = new Thread(()->{

            try {
                semaphore.acquire();
                for (int i = 0; i < 5; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);



                }

                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t1");

        t1.start();

        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }
}
