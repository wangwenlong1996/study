package name.wwl.demo.study.juc.c_000;

/**
 * 启动线程的三种方式 1：Thread 2: Runnable 3:Executors.newCachedThrad
 */
public class T02_HowToCreateThread {
    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("hello MyThread");
        }
    }

    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();

        new Thread(new MyRun()).start();


        new Thread(
                ()->{
                    System.out.println("hello lambda");
                }
        ).start();
    }
}
