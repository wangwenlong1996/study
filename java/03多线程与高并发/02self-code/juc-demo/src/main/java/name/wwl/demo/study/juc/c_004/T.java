package name.wwl.demo.study.juc.c_004;

/**
 * synchronized关键字
 * 对某个对象加锁
 * @author mashibing
 */
public  class T {

    private static int count = 100;


    public synchronized static void m() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "count=" + count);

    }

    public static void mm(){
        synchronized (T.class){
            count --;
        }
    }


}
