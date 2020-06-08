package name.wwl.demo.study.juc.c_022_RefTypeAndThreadLocal;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.ref.WeakReference;

/**
 * 弱引用遭到gc就会回收
 *
 */
public class T03_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m= new WeakReference<>(new M());


        System.out.println(m.get());

        System.gc();

        System.out.println(m.get());

        ThreadLocal<M> t1= new ThreadLocal<>();

        t1.set(new M());

        t1.remove();
    }
}
