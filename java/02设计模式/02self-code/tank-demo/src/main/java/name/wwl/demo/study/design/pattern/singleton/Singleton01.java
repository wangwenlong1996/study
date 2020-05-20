package name.wwl.demo.study.design.pattern.singleton;

/**
 *  饿汉式
 *  加载到内存后，就实例化一个单例，JVM保证线程安全
 *  简单实用，推荐使用！
 *  唯一缺点：不管用到与否，类装载时就完成实例化
 */
public class Singleton01 {

    private final static Singleton01 INSTANCE =  new Singleton01();
    private Singleton01(){

    }

    public static   Singleton01 getInstance(){
        return INSTANCE;
    }

    public void helloWorld(){
        System.out.println("hello world");
    }
    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Singleton01.getInstance().hashCode());
            }).start();
        }

    }
}
