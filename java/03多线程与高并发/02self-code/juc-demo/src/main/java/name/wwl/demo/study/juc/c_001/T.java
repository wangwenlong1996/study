package name.wwl.demo.study.juc.c_001;

/**
 * synchronized关键字
 * 对某个对象加锁
 * @author mashibing
 */
public class T {

    private static int count = 1000;

    private static Object o = new Object();

    public static void m(){
        synchronized (o){
            try {
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            count--;
            System.out.println(Thread.currentThread().getName()+"count="+count);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                m();
            }).start();
        }
    }


}
