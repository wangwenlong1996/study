package name.wwl.demo.study.design.pattern.singleton;

/**
 * DCL  相对完美
 */
public class Singleton06 {


    private volatile static Singleton06 INSTANCE;

    private Singleton06() {

    }

    public static Singleton06 getInstance() {

        if (INSTANCE == null) {
            synchronized (Singleton06.class) {
                if (INSTANCE ==null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton06();
                }
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
                System.out.println(Singleton06.getInstance().hashCode());
            }).start();
        }

    }
}
