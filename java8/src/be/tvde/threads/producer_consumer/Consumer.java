package be.tvde.threads.producer_consumer;

/**
 * Created by tomvde on 3/01/2017.
 */
public class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int data;
        while (true) {
            data = buffer.consume();
        }
    }
}
