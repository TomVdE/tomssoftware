package be.tvde.threads.executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tomvde on 6/01/2017.
 */
public class RunnableTaskTest {

    public static void main(String[] args) {
        final int THREAD_COUNT = 3;
        final int LOOP_COUNT = 3;
        final int TASK_COUNT = 5;

        //Get an executor with three threads in its thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        //Create five tasks and submit to the executor
        for (int i = 1; i <= TASK_COUNT; i++) {
            RunnableTask task = new RunnableTask(i, LOOP_COUNT);

            executorService.submit(task);
        }

        //Let's shutdown the executor
        executorService.shutdown();
    }
}
