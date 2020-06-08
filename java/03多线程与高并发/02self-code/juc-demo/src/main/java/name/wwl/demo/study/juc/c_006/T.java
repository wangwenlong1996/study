package name.wwl.demo.study.juc.c_006;


import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

/**
 * synchronized关键字
 * 对某个对象加锁
 * @author mashibing
 */
public  class T implements Runnable {

    private/** volatile*/ int count = 100;


    @Override
    public synchronized  void run() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "count=" + count);

    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 100; i++) {
            new Thread(t,"Thread"+i).start();
        }
    }


}
