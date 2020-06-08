package name.wwl.demo.study.juc.c_021_01_interview;



import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *
 * 使用wait和notify/notifyAll来实现
 *
 * 使用Lock和Condition来实现
 * 对比两种方式，Condition的方式可以更加精确的指定哪些线程被唤醒
 *
 * @author mashibing
 */
public class MyContainer2<T> {
    final private LinkedList<T> lists = new LinkedList<>();

    final private int MAX = 10;

    private int count = 0;

    private ReentrantLock lock = new ReentrantLock();

    private Condition producter = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t){
        try {


            lock.lock();
            while (lists.size() == MAX) {

                System.out.println("生产者队列满了");
                producter.await();
            }

            lists.add(t);
            ++count;

            consumer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;

        try {
            lock.lock();

            while (lists.size() ==0){
                try {
                    System.out.println("消费完了");
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            t = lists.removeFirst();

            count --;

            producter.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        return t;
    }

    public static void main(String[] args) {
        MyContainer2<String> c = new MyContainer2<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName() + " " + j+""+c.get());
                }
            },"c"+i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }

        for (int i = 0; i <2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            },"p"+i).start();
        }
    }

}
