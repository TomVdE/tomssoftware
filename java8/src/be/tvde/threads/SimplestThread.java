package be.tvde.threads;

/**
 * Created by tomvde on 29/12/2016.
 */
public class SimplestThread {

    public static void main(String[] args) throws InterruptedException {
        //Create a new thread object
        Thread t = new Thread();
        t.start();


        Thread.sleep(500);
        System.out.println(t.isAlive());
    }
}
