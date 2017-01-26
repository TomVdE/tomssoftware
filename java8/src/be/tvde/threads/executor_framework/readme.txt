A task is a logical unit of work, and typically a thread is used to represent and execute a task.

A task may be represented as a Runnable. If you want to manage tasks using threads, follow the steps described below.
You can create a class to represent a task.

Standard way of working with tasks = threads
    See StandardThreads.java

    - if you want to get the result of a task execution -> additional code -> managing tasks becomes difficult, if not
    impossible
    - Question you have to ask yourself: 'How many tasks should be created to execute a group of tasks?'

        * a thread per task
            - thread creation/destruction = overhead
            - each thread consumes resources
            - max number of threads supported can be limited on a platform -> application crash?

        * create on thread + let it handle the execution of all tasks
            - =sequential executor -> delay
            - deadlock-prone of tasks depend on results of other tasks
            - long-running tasks -> unresponsiveness

The executor framework attempts to solve all of these aspects of a task execution.
    The framework provides a way to SEPERATE task SUBMISSION from task EXECUTION. You create a task and submit it to
    an executor. The executor takes care of the execution details of the task.

    It provides CONFIGURABLE policies to control many aspects of the task EXECUTION.

See TasksWithExecutorFramework.java

    Note that when you used an executor, you did not create three threads to execute the three tasks. The executor will
    decide that for you.
You just called the execute() method of the executor to submit a task.
The executor will manage the threads that will execute the tasks and other details about the task execution.

The executor framework provides a class library to select the policies on the thread usage to execute the tasks.
You can choose to run all tasks in one thread, in a fixed number of threads, or in a variable number of threads.

In fact, you can choose a thread pool to execute your tasks, and the thread pool is configurable as to how many threads
will be in the pool and how those threads will be maintained. In any case, all threads in the pool are reused as they
become available. Using a thread pool to execute the submitted tasks has two important advantages:

    * The overhead of creating and destroying new threads is reduced.
    * The executor reuses the threads from the thread pool. If a thread is available in the thread pool at the time of
    a task submission, the task may  start immediately. This eliminates the time delay between the thread creation and
    the task execution.

It is important to mention another interface called ExecutorService at this point.
It provides some advanced features of an executor, which include
    - managing the shutdown of the executor
    - checking the status of the submitted tasks
It inherits the Executor interface.

Some of the important methods of this interface are
    - shutdown(),
    - shutdownNow(),
    - submit(),
    - awaitTermination().

It is important that you shut down the executor when it is no longer needed. The executor framework creates
non-daemon threads to execute the tasks. Generally, when a thread is done executing a task, it is not destroyed.
Rather it is kept in the thread pool for reuse in the future. (Whether a thread is destroyed or kept depends on the
thread pool configuration).
A Java application will not exit if some non-daemon threads are still alive.
Therefore, if you forget to shut down the executor, your application may never exit.

How does an executor handle a task execution?
    You specify the type of thread pool that the executor should use to manage the tasks at the time you create the
    executor.

        - All tasks that you submit to an executor are queued in a queue known as the work queue.

        - As a thread becomes available, it removes a task from the work queue and executes it.

        - When a thread is done executing a task, depending on your thread pool type, your executor either destroys the
        thread or puts it back into the pool so it can be reused to execute another task.

You have a number of options to decide on what kind of thread pool to use for an executor:

    * You can use one of the factory methods of the Executors class to get an executor, which has a preconfigured
    thread pool and lets you reconfigure it, if you desire so. You will use this approach to get an executor in your
    examples.

    * You can also use this class to get a preconfigured executor that cannot be reconfigured. The commonly used methods
    of the Executors class to get an executor service are as follows:

        + newCachedThreadPool()
             returns an ExecutorService object

             The thread pool reuses the previously created threads if they are available. Otherwise, it creates a new
             thread to execute a task.
             It destroys and removes idle threads from the pool.
             The thread pool has characteristics of expanding and shrinking depending on the workload.

        + newFixedThreadPool(int nThreads)
             returns an ExecutorService object

             The thread pool maintains a fixed number of threads.
             At any time, the thread pool will have the maximum nThread number of threads.
             If a task arrives in the work queue and all threads are busy executing other tasks, the task has to wait
             for its execution until a thread becomes available. If a thread is terminated because of an unexpected
             failure during a task execution, it is replaced with a new thread.

        + newSingleThreadExecutor()
             returns an ExecutorService object

              The thread pool maintains only one thread to execute all tasks. It guarantees that only one task will be
              executed at a time. If the lone thread dies unexpectedly, it is replaced with a new one.

    * You can instantiate the ThreadPoolExecutor class and configure the thread pool

    * You can create your own executor from scratch.

Result-Bearing Tasks
--------------------

How do you get the result of a task when it is complete?
The task that can return a result upon its execution has to be represented as an instance of the Callable<V> interface.
The type parameter V is type of the result of the task.

Note that the run() method of the Runnable interface cannot return a value and it cannot throw any checked exception.
The Callable interface has a call() method.
    It can return a value of any type.
    It allows you to throw an exception.

It is declared as follows:

    public interface Callable<V> {
        V call() throws Exception;
    }

See CallableTaskTest.java
    * The CallableTask class defines the call() method, which contains the logic for task processing.
    It sums up all the sleep times for the task and returns it.

    * The CallableTaskTest class uses an executor with three threads in its thread pool.

    * The ExecutorService.submit() method returns a Future object.
        Future is an interface that lets you track the progress of the task that you submit.
        It is declared as follows:

            public interface Future<V> {
                boolean cancel(boolean mayInterruptIfRunning);
                V get() throws InterruptedException, ExecutionException;
                V get(long timeout, TimeUni t unit) throws InterruptedException, ExecutionException, TimeoutException;
                boolean isCancelled();
                boolean isDone();
            }

            - The get() method returns the result of the task execution, which is the same as the returned value from
                the call() method of a Callable object.
                If the task has not yet finished executing, the get() method blocks. You can use another version of
                the get() method to specify a timeout period for waiting for the result of a task execution.

            - The cancel() method cancels a submitted task. Its call has no effect on a completed task. It accepts a
                boolean argument to indicate if the executor should interrupt the task if the task is still running.
                If you use cancel(true) to cancel a task, make sure the task responds to the interruption properly.

            - The isDone() method tells you if the task has finished executing.
                It returns true if
                    + the task is finished executing normally,
                    + it has been cancelled, or
                    + it had an exception during its execution.

In the CallableTaskTest class, you keep the returned Future object in the submittedTask variable.
The Future<Integer> declaration indicates that your task returns an Integer object as its result.

    Future<Integer> submittedTask = exec.submit(task);

Another important method call is the get() method on submittedTask.

    Integer result = submittedTask.get();

I have placed the call to the get() method in a try-catch block because it may throw an exception. If the task has not
finished executing, the get() method will block. The program prints the result of the task execution, which is the
total time that the task spent sleeping during its execution. Finally, you shut down the executor using its shutdown()
method.

