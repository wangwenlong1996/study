package name.wwl.demo.study.juc.c_023;

import java.util.Arrays;

public class Singleton {

    private Singleton(){
        System.out.println("singleton");

    }

    private static class Inner{
        private static Singleton s = new Singleton();
    }

    public static Singleton getSingle(){
        return Inner.s;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[200];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                System.out.println(Singleton.getSingle());
            });
        }

        Arrays.asList(threads).forEach(o ->o.start());
    }
}
