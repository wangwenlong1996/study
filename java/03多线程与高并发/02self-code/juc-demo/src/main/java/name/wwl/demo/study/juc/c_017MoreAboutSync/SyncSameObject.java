package name.wwl.demo.study.juc.c_017MoreAboutSync;


import java.util.concurrent.TimeUnit;

/**
 * 锁定某对象o，如果o的属性发生改变，不影响锁的使用
 * 但是如果o变成另外一个对象，则锁定的对象发生改变
 * 应该避免将锁定对象的引用变成另外的对象
 * @author mashibing
 */
public class SyncSameObject {

    /*final*/ Object o = new Object();


    void m(){
        synchronized (o){
            while (true){

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName());
            }
        }
    }

}
