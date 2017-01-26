package be.tvde.threads.producer_consumer;

import java.util.Random;

/**
 * Created by tomvde on 3/01/2017.
 */
public class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        Random r = new Random();

        while (true) {
            //Generate a random integer and store it in the buffer
            int n = r.nextInt();
            buffer.produce(n);
        }
    }
}
