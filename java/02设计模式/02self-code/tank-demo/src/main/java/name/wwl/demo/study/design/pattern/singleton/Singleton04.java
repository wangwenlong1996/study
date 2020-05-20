package name.wwl.demo.study.design.pattern.singleton;

/**
 *
 *  通过synchronized解决线程不安全，但也带来效率下降
 */
public class Singleton04 {

    private static Singleton04 INSTANCE;

    private Singleton04(){

    }

    public static synchronized Singleton04 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton04();
        }
        return INSTANCE;

    }

    public void helloWorld(){
        System.out.println("hello world");
    }
    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton04.getInstance().hashCode());
            }).start();
        }

    }
}
