package be.tvde.threads;

/**
 * Created by tomvde on 29/12/2016.
 */
public class CriticalSections {

    //instance method
    //synchronized method
    public synchronized void someMethod_1() {
        // method code goes here
        // only one thread can execute here at a time
    }

    //instance method
    //synchronized as a block
    public void someMethod_11() {
        synchronized (this) {
            // method code goes here
            // only one thread can execute here at a time
        }
    }

    //instance method
    //part of the method is synchronized as a block
    public void someMethod_12() {
        // some statements go here
        // multiple threads can execute here at a time

        synchronized (this) {
            // some statements go here
            // only one thread can execute here at a time
        }
        // some statements go here
        // multiple threads can execute here at a time
    }

    //static method
    // class’s object monitor will be used to achieve the synchronization
    public static synchronized void someMethod_2() {
        // method code goes here
        // only one thread can execute here at a time
    }

    //static method
    // class’s object monitor will be used to achieve the synchronization
    public static void someMethod_21() {
        synchronized (CriticalSections.class) {
            // method code goes here
            // only one thread can execute here at a time
        }
    }

    //static method
    // class’s object monitor will be used to achieve the synchronization
    public static void someMethod_22() {
        // some statements go here: section_1
        // multiple threads can execute here at a time

        synchronized (CriticalSections.class) {
            // some statements go here: section_2
            // only one thread can execute here at a time
        }
        // some statements go here: section_3
        // multiple threads can execute here at a time
    }
}