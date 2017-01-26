package be.tvde.threads.executor_framework;

/**
 * Created by tomvde on 6/01/2017.
 */
public class StandardThreads {

    public static void main(String[] args) {
        MyTask task1 = new MyTask();
        MyTask task2 = new MyTask();
        MyTask task3 = new MyTask();

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        //Task processing logic goes here
    }
}
