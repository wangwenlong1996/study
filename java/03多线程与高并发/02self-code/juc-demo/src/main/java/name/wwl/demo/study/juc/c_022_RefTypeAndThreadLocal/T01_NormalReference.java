package name.wwl.demo.study.juc.c_022_RefTypeAndThreadLocal;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class T01_NormalReference {

    public static void main(String[] args) throws IOException {
        M m = new M();

//        m = null;

        System.gc();

        System.out.println("==========");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m = null;
        System.gc();

        System.out.println("==========");



        System.in.read();
    }
}
