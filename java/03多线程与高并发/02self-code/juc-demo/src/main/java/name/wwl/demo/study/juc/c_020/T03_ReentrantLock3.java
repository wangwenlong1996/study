package name.wwl.demo.study.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock用于替代synchronized
 * 由于m1锁定this,只有m1执行完毕的时候,m2才能执行
 * 这里是复习synchronized最原始的语义
 *
 * 使用reentrantlock可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁（重要的事情说三遍）
 * 使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 *
 * 使用reentrantlock可以进行“尝试锁定”tryLock，这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 * @author mashibing
 */
public class T03_ReentrantLock3 {
    Lock lock = new ReentrantLock();


    void m1(){
        try {
            lock.lock();

            for (int i = 0; i < 30; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2(){

        boolean locked = false;


        try {
                locked = lock.tryLock(5,TimeUnit.SECONDS);
                System.out.println("m2..."+locked);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        if (locked) lock.unlock();
    }

    }

    public static void main(String[] args) {
        T03_ReentrantLock3 r3 = new T03_ReentrantLock3();

        new Thread(r3::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        new Thread(r3::m2).start();
    }
}
