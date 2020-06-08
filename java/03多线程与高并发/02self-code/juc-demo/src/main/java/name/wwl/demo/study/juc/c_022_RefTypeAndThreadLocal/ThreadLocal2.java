package name.wwl.demo.study.juc.c_022_RefTypeAndThreadLocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocal2 {

    static ThreadLocal<Person1> p = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(p.get());
        }).start();

        new Thread(()->{
            try  {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            p.set(new Person1());
        }).start();


    }

}

class Person1{
    String name = "zhangsan";
}
