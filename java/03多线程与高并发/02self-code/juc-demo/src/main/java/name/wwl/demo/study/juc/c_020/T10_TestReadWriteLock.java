package name.wwl.demo.study.juc.c_020;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class T10_TestReadWriteLock {

    static Lock lock = new ReentrantLock();


    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

     public static void read(Lock lock){
         try {
             lock.lock();
             Thread.sleep(1000);
             System.out.println("read over");
         }catch (InterruptedException e){
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
     }

     public static void write(Lock lock,int v){
         try {
             lock.lock();
             Thread.sleep(1000);
             value = v;
             System.out.println("write Over");
         }catch (InterruptedException e){
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
     }

    public static void main(String[] args) {
        Runnable readR  = () ->read(readLock);

        Runnable writeR = ()->write(writeLock, new Random().nextInt());

        for(int i=0; i<18; i++) new Thread(readR).start();
        for(int i=0; i<2; i++) new Thread(writeR).start();

        for(int i=0; i<18; i++) new Thread(readR).start();

        Runnable readR1 = ()-> read(lock);
        Runnable writeR1 = ()->write(lock, new Random().nextInt());

        for(int i=0; i<18; i++) new Thread(readR1).start();
        for(int i=0; i<2; i++) new Thread(writeR1).start();

        for(int i=0; i<18; i++) new Thread(readR1).start();
    }
}
