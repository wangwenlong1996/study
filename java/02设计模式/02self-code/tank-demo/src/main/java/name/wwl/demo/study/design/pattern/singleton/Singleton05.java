package name.wwl.demo.study.design.pattern.singleton;

/**
 *  妄图通过减小同步代码块的方式提高效率，然后造成线程不安全
 */
public class Singleton05 {


    private static Singleton05 INSTANCE;

    private Singleton05() {

    }

    public static Singleton05 getInstance() {

        if (INSTANCE == null) {
            synchronized (Singleton05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;

    }

    public void helloWorld() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton05.getInstance().hashCode());
            }).start();
        }

    }
}
