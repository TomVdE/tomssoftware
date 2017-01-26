package be.tvde.threads.executor_framework;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by tomvde on 6/01/2017.
 */
public class TasksWithExecutorFramework {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
        System.out.println("");
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();

        Executor executor = Executors.newCachedThreadPool();
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);



    }
}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing task");


        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
        System.out.println("");
    }
}
