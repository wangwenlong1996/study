package name.wwl.demo.study.design.pattern.singleton;

/**
 * 静态内部类方式
 *  JVM保证单例
 *  加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Singleton07 {


    private Singleton07() {

    }

    private static class Singleton07Holder{
        private final static Singleton07 INSTANCE= new Singleton07();
    }

    public static Singleton07 getInstance() {
        return Singleton07Holder.INSTANCE;
    }

    public void helloWorld() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton07.getInstance().hashCode());
            }).start();
        }

    }
}
