package be.tvde.threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by tomvde on 29/12/2016.
 */
public class MultiLocks {
    public synchronized void method_1() {
        // some statements go here
        this.method_2();
        // some statements go here
    }

    public synchronized void method_2() {
        // some statements go here
    }

    public static synchronized void method_3() {
        // some statements go here
        MultiLocks.method_4();
        // some statements go here
    }

    public static synchronized void method_4() {
        // some statements go here

    }
}
