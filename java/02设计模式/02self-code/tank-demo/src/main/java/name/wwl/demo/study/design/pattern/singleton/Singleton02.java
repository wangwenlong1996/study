package name.wwl.demo.study.design.pattern.singleton;

public class Singleton02 {
    private static Singleton02 INSTANCE;

    static {
        INSTANCE = new Singleton02();
    }

    private Singleton02(){

    }

    public static   Singleton02 getInstance(){
        return INSTANCE;
    }

    public void helloWorld(){
        System.out.println("hello world");
    }
    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton02.getInstance().hashCode());
            }).start();
        }

    }
}
