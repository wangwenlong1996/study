package name.wwl.demo.study.juc.c_016_LockOptimization;

import java.util.concurrent.TimeUnit;

public class FineCoarseLock {

    int count = 0;

    synchronized void m1(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count++;  	//业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
        //采用细粒度的锁，可以使线程争用时间变短，从而提高效率
        synchronized (this) {
            count++;    //业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
