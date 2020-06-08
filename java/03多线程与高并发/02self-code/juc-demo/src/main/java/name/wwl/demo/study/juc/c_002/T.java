package name.wwl.demo.study.juc.c_002;

/**
 * synchronized关键字
 * 对某个对象加锁
 * @author mashibing
 */
public  class T {

    private int count = 100;


    public void m(){
        synchronized (this){
            try {
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            count--;
            System.out.println(Thread.currentThread().getName()+"count="+count);
        }
    }


}
