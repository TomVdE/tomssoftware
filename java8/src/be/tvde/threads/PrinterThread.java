package be.tvde.threads;

/**
 * Created by tomvde on 29/12/2016.
 */
public class PrinterThread {

    public static void main(String[] args) {
        // Create a Thread object
        Thread t = new Thread(PrinterThread::print);
        // Start the thread
        t.start();
    }

    public static void print() {
        for (int i = 1; i <= 500; i++) {
            System.out.print(i + " ");
        }
    }
}
