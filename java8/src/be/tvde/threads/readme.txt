Terms
=====

Program
-------

algorithm expressed in a programing language

Process
-------

running instance of a program, with all system resources allocated by the operating system
            to that instance of the program:
                - unique identifier,
                - program counter,
                - executable code,
                - an address space,
                - open handles to system resources,
                - a security context,
                - ...

Program counter (instruction pointer)
---------------

a value maintained in the CPU register that keeps track of the instruction
        being executed by the CPU.

Multitasking
------------

ability of an operating system to execute multiple tasks (or processes) at once.

On a single CPU machine, multitasking is not possible in a true sense because one CPU can execute instructions for
only one process at a time. In such a case, the operating system achieves multitasking by dividing the single CPU time
among all running processes and switching between processes quickly enough to give an impression that all processes
are running simultaneously.

The switching of the CPU among processes is called a CONTEXT SWITCH.
In a context switch, the running process is stopped, its state is saved, the state of the process that is going to get
the CPU is restored, and the new process is run.

It is necessary to save the state of the running process before the CPU is allocated to another process, so when
this process gets the CPU again, it can start its execution from the same point where it left.

Typically, a PROCESS STATE consists of a program counter, register values used by the process, and any other pieces of
information that are necessary to restore the process later.
An operating system stores a process state in a data structure, which is called a PROCESS CONTROL BLOCK or a SWITCHFRAME.

A context switch is rather an expensive task.

There are two types of multitasking: cooperative and preemptive.

COOPERATIVE MULTITASKING: the running process decides when to release the CPU so that other processes can use it.
PREEMPTIVE MULTITASKING: the operating system allocates a time slice to each process.

In cooperative multitasking, a process may monopolize the CPU for a long time and other processes may not get a chance
to run. In preemptive multitasking, the operating system makes sure all processes get CPU time.
UNIX, OS/2, and Windows (except Windows 3.x) use preemptive multitasking. Windows 3.x used cooperative multitasking.

Multiprocessing
---------------

ability of a computer to use more than one processor simultaneously

Parallel processing
-------------------

ability of a system to simultaneously execute the same task on multiple processors

You may note that, for parallel processing, the task must be split up into subtasks, so that the subtasks can be
executed on multiple processors simultaneously.



All threads within a process share all resources including the address space; they can also communicate with each
other easily because they operate within the same process and they share the same memory. Each thread within a process
operates independent of the other threads within the same process.

A thread maintains two things:
    - a program counter
        lets a thread keep track of the instruction that is currently executed
    - a stack
        to store the values of the local variables

A thread can also maintain its private memory, which cannot be shared with other threads, even if they are in the same
process. The private memory maintained by a thread is called THREAD-LOCAL STORAGE (TLS).



In all modern operating systems, threads are scheduled on the CPU for execution, not the processes. Therefore, the CPU
context switch occurs between the threads. The context switch between threads is less expensive compared to the context
switch between processes. Because of the ease of communication, sharing resources among threads within a process, and
a cheaper context switch, it is preferred to split a program into multiple threads, rather than multiple processes.

Creating a Thread in Java
-------------------------

Java lets you represent a thread as an object of class java.lang.Thread

two steps:
    - creating an object of the Thread class
        just allocates memory for that object on the heap

    - invoking the start() method of the Thread class
         method returns after doing some housekeeping work
         puts the thread in the runnable state = thread is ready to receive the CPU time

         Note that invoking the start() method of a Thread object does not guarantee “when” this thread will start
         getting the CPU time. That is, it does not guarantee when the thread will start running. It just schedules
         the thread to receive the CPU time.

Specifying Your Code for a Thread
---------------------------------

three ways:

- inheriting your class from the Thread class
- implementing the Runnable interface in your class
- using the method reference to a method that takes no parameters and returns void

!!! Inheriting your class from the Thread class may not be possible if your class already inherits from another class.
In that case, you will need to use the second method.

You can use the third method from Java 8. Before Java 8, it was common to use an anonymous class to define a thread
object where the anonymous class would either inherit from the Thread class or implement the Runnable interface.

Inheriting Your Class from the Thread Class
+++++++++++++++++++++++++++++++++++++++++++

Override the run() method

Implementing the Runnable Interface
+++++++++++++++++++++++++++++++++++

Create a class that implements the java.lang.Runnable interface.
Runnable is a functional interface and it is declared as follows:

@FunctionalInterface
public interface Runnable {
    void run();
}

From Java 8, you can use a lambda expression to create an instance of the Runnable interface.

Runnable aRunnableObject = () -> System.out.println("Hello Java thread!");

Create an object of the Thread class using the constructor that accepts a Runnable object.

    Thread myThread = new Thread(aRunnableObject);

Start the thread by calling the start() method of the thread object.

    myThread.start();

Using a Method Reference
++++++++++++++++++++++++

From Java 8, you can use the method reference of a method of any class that
    - takes no parameters
    - returns void
as the code to be executed by a thread.

The following code declares a ThreadTest class that contains an execute() method.
The method contains the code to be executed in a thread.

public class ThreadTest {
    public static void execute() {
        System.out.println("Hello Java thread!");
    }
}

The following snippet of code uses the method reference of the execute() method of the ThreadTest class to create
a Runnable object:

Thread myThread = new Thread(ThreadTest::execute);
myThread.start();

See PrinterThread.java

Using Multiple Threads in a Program
-----------------------------------

As simple as creating multiple Thread objects and starting them.
Java does not have any upper limit on the number of threads that can be used in a program.
It is limited by the operating system and the memory available to the program.

The situation where multiple threads manipulate and access a shared data concurrently and the outcome depends on the
order in which the execution of threads take place is known as a RACE CONDITION. A race condition in a program may
lead to unpredictable results.
ex. See BalanceUpdate.java

This kind of problem that needs synchronizing the access of multiple threads to a section of code in a Java program can
be solved using the synchronized keyword.



In a multi-threaded program, a section of code that may have undesirable effects on the outcome of the program if
executed by multiple threads concurrently is called a CRITICAL SECTION.

Controlling and coordinating the access to a critical section by multiple threads is known as THREADS SYNCHRONIZATION

Two kinds of threads synchronizations are built into the Java programming language:

* Mutual exclusion synchronization
    only one thread is allowed to have access to a section of code at a point in time
    you can think of the mutual exclusion as an exclusive access to the code by a thread

    Mutual exclusion synchronization is achieved through a lock. A lock supports two operations:
            acquire
            release
    A thread that wants exclusive access to a resource must acquire the lock associated with that resource. As long
    as a thread possesses the lock to a resource, other threads cannot acquire the same lock. Once the thread that
    possesses the lock is finished with the resource, it releases the lock so another thread can acquire it.

* Conditional synchronization
    The conditional synchronization allows multiple threads to work together to achieve a result.
    For example, consider a multi-threaded program to solve a producer/consumer problem.

    There are two threads in a program: one thread produces data (the producer thread) and another thread consumes
    the data (the consumer thread).
    The consumer thread must wait until the producer thread produces data and makes it available for consuming.
    The producer thread must notify the consumer thread when it produces data so the consumer thread can consume it.

    In other words, producer and consumer threads must coordinate/cooperate with each other to accomplish the task.

    During conditional synchronization, mutual exclusion synchronization may also be needed. Suppose the producer
    thread produces data one byte at a time and puts the data into a buffer whose capacity is also one byte. The
    consumer thread consumes data from the same buffer.
    In this case, only one of the threads should have access to the buffer at a time (a mutual exclusion). If the
    buffer is full, the producer thread must wait for the consumer thread to empty the buffer; if the buffer is empty,
    the consumer thread must wait for the producer thread to produce a byte of data and put it into the buffer
    (a conditional synchronization).

    Conditional synchronization is achieved through condition variables and three operations:
            wait
            signal
            broadcast

    Condition variables define the conditions on which threads are synchronized.

    The wait operation makes a thread wait on a condition to become true so it can proceed.
    The signal operation wakes up one of the threads that was waiting on the condition variables.
    The broadcast operation wakes up all threads that were waiting on the condition variables.

    Note that the difference between the signal operation and broadcast operation is that the former wakes up only one
    waiting thread, whereas the latter wakes up all waiting threads.

A monitor is a programming construct that has a lock, condition variables, and associated operations on them. Threads
synchronization in a Java program is achieved using monitors.
Every object in a Java program has an associated monitor.
A critical section in a Java program is defined with respect to an object’s monitor. A thread must acquire the
object’s monitor before it can start executing the piece of code declared as a critical section. The synchronized
keyword is used to declare a critical section.

There are two ways to use the synchronized keyword:

* To declare a method as a critical section
    You can declare a method as a critical section by using the keyword synchronized before the method’s return type

    !!! You can declare an instance method as synchronized
            Entire method is a critical section and it is associated with the monitor of the object for which this
            method is executed. That is, a thread must acquire the object’s monitor lock before executing the code
            inside a synchronized instance method of that object

    !!! You can declare a static method as synchronized
            Entire method is a critical section and it is associated with the class object that represents that class
            in memory. That is, a thread must acquire the class object’s monitor lock before executing the code inside
            a synchronized static method of that class

    !!! A constructor cannot be declared as synchronized. But a block of statements in the constructor can.

* To declare a block of statements as a critical section
    synchronized(<objectReference>) {
        // one or more statements of the critical section
    }

A thread that has acquired an object’s monitor lock can acquire it again as many times as it wants. However, it must
release the object’s monitor lock as many times as it had acquired it in order for another thread to acquire the same
object’s monitor lock.

See CriticalSections.java

A thread that has acquired an object’s monitor lock can acquire it again as many times as it wants. However, it must
release the object’s monitor lock as many times as it had acquired it in order for another thread to acquire the same
object’s monitor lock.

See MultiLocks.java


How is a thread placed in the wait set?
---------------------------------------

A thread can be placed in the wait set of an object monitor only if it once acquired the object’s monitor lock.

Once a thread has acquired the object’s monitor lock, it must call the wait() method of the object in order to place
itself into the wait set.

This means a thread must always call the wait() method from inside a synchronized method or a block.

The wait() method is defined in the java.lang.Object class and it is declared final -> cannot be overridden.

You must consider the following two rules before you call the wait() method of an object.

* call to the wait() method must be placed inside a synchronized method (static or non-static) or a synchronized block.

* The wait() method must be called on the object whose monitor the current thread has acquired.

  It throws a java.lang.InterruptedException. The code that calls this method must handle this exception.

  The wait() method throws an IllegalMonitorStateException when the current thread is not the owner of the object’s
  monitor.

  The following snippet of code does not place the wait() method call inside a try-catch to keep the code simple and
  readable.


The threads in the entry set are blocked and they are ready to grab access to the monitor as soon as possible.
The threads in the wait set are waiting for some condition to occur.
A thread that has ownership of the monitor must notify the threads waiting in the wait set about the fulfillment of
the conditions on which they are waiting.

In Java, the notification is made by calling the notify() and notifyAll() methods of the java.lang.Object class.

Like the wait() method, the notify() and notifyAll() methods are also declared final.

Like the wait() method, these two methods must be called by a thread using an object whose monitor has already been
acquired by the thread.

If a thread calls these methods on an object before acquiring the object’s monitor, a
java.lang.IllegalMonitorStateException is thrown.

The call to the notify() method wakes up one thread from the wait set, whereas the call to the notifyAll() method
wakes up all threads in the wait set. In case of the notify() method call, the thread that is woken up is chosen
arbitrarily. Note that when a thread calls the notify() or notifyAll() method, it still holds the lock on the object’s
monitor.

Threads in the wait set are only woken up by the notify() or notifyAll() call. They do not acquire the object’s monitor
lock immediately. When the thread that called the notify() or notifyAll() method releases the object’s monitor lock
by “Release and exit” or “Release and wait,” the woken up threads in the wait set competes with the threads in the
entry set to acquire the object’s monitor again. Therefore, a call to the notify() and notifyAll() serves only as a
wake-up call for threads in the wait set and it does not guarantee access to the object’s monitor.

!!! There is no way to wake up a specific thread in the wait set. The call to notify() chooses a thread  arbitrarily,
whereas the call to notifyAll() wakes up all threads. Use notifyAll() when you are in doubt about which method to use.

Once a thread is woken up in the WAIT SET, it has to compete with the threads in the ENTRY SET to acquire the monitor
lock of the object.
After a thread is woken up in the wait set and acquires the object’s monitor lock, it has choices:

    - to do some work and release the lock by invoking the wait() method (release and wait) again,
    - release the lock by exiting the synchronized section (release and exit).

One important point to remember about the call to the wait() method is that, typically, a call to the wait() method is
placed inside a loop. Here is the reason why it is necessary to do so. A thread looks for a condition to hold. It
waits by calling the wait() method and placing itself in the wait set if that condition does not hold. The thread
wakes up when it is notified by another thread, which calls the notify() or notifyAll() method. When the thread that
woke up acquires the lock, the condition that held at the time of notification may not still hold.
Therefore, it is necessary to check for the condition again, when the thread wakes up and acquires the lock, to make
sure the condition it was looking for is true, and it can continue its work.

 “Which thread gets a chance to acquire the object’s monitor lock when there are some blocked threads in the entry set
 and some woken up threads in the wait set?”
    Note that the threads that are in the wait set do not compete for the object’s monitor until they are woken up by
    the notify() or notifyAll() call. The answer to this question is that it depends on the scheduler’s algorithm of
    the operating system.

The wait() method in the java.lang.Object class is overloaded and it has three versions:

- wait(): The thread waits in the object’s wait set until another thread calls the notify() or notifyAll() method
on the same object.

- wait(long timeinMillis): The thread waits in the object’s wait set until another thread calls the notify() or
notifyAll() method on the same object or the specified amount of timeinMillis time has elapsed.

- wait(long timeinMillis, long timeinNanos): This version lets you specify time in milliseconds and nanoseconds.

Which Thread Is Executing?
--------------------------

The Thread class has some useful static methods; one of them is the method currentThread().

It returns the reference of the Thread object that calls this method.

Consider the following statement:
    Thread t = Thread.currentThread();

The statement will assign the reference of the thread object that executes the above statement to the variable t.

Note that a statement in Java can be executed by different threads at different points in time during the execution of
a program. Therefore, t may be assigned the reference of a different Thread object when the statement is executed at
different times in the same program.

Letting a Thread Sleep
----------------------

The Thread class contains a static sleep() method, which makes a thread sleep for a specified duration.

It accepts a timeout as an argument. You can specify the timeout in milliseconds, or milliseconds and nanoseconds.

The thread that executes this method sleeps for the specified amount of time. A sleeping thread is not scheduled by
the operating system scheduler to receive the CPU time.

If a thread has the ownership of an object’s monitor lock before it goes to sleep, it continues to hold those monitor
locks.
The sleep() method throws a java.lang.InterruptedException and your code should be ready to handle it.

I will Join You in Heaven
-------------------------

I can rephrase this section heading as “I will wait until you die.”
That’s right. A thread can wait for another thread to die (or terminate). Suppose there are two threads, t1 and t2. If
the thread t1 executes t2.join(), thread t1 starts waiting until thread t2 is terminated.

In other words, the call t2.join() blocks until t2 terminates. Using the join() method in a program is useful if one of
the threads cannot proceed until another thread has finished executing.

Priority of a Thread
--------------------

All threads have a priority. The priority is indicated by an integer between 1 and 10.

A thread with the priority  of 1 is said to have the lowest priority.
A thread with the priority of 10 is said to have the highest priority.

There are three constants defined in the Thread class to represent three different thread priorities:

    MIN_PRIORITY    1
    NORM_PRIORITY   5
    MAX_PRIORITY    10

The priority of a thread is a hint to the scheduler that indicates the importance (or the urgency) with which it should
schedule the thread.
The higher priority of a thread indicates that the thread is of higher importance and the scheduler should give
priority in giving the CPU time to that thread.

Note that the priority of a thread is just a hint to the scheduler; it is up to the scheduler to respect that hint.

It is not recommended to depend on the thread priority for the correctness of a program.
For example, if there are ten maximum priority threads and one minimum priority thread, that does not mean that the
scheduler will schedule the minimum priority thread after all ten maximum priority threads have been scheduled and
finished.
This scheduling scheme will result in a thread starvation, where a lower priority thread will have to wait indefinitely
or for a long time to get CPU time.

The setPriority() method of the Thread class sets a new priority for the thread.
The getPriority() method returns the current priority for a thread.

When a thread is created, its priority is set to the priority of the thread that creates it.

Is It a Demon or a Daemon?
--------------------------

A thread can be a daemon thread or a user thread.

A daemon thread is a kind of a service provider thread, whereas a user thread (or non-daemon thread) is a thread that
uses the services of daemon threads.

A service provider should not exist if there is no service consumer.

The JVM applies this logic. When it detects that all threads in an application are only daemon threads, it exits the
application.

Note that if there are only daemon threads in an application, the JVM does not wait for those daemon threads to finish
before exiting the application.

You can make a thread a daemon thread by using the setDaemon() method by passing true as its argument.
You must call the setDaemon() method of a thread before you start the thread. Otherwise, an
java.lang. IllegalThreadStateException is thrown.

You can use the isDaemon() method to check if a thread is a daemon thread.

When a thread is created, its daemon property is the same as the thread that creates it.
In other words, a new thread inherits the daemon property of its creator thread.

Am I Interrupted?
-----------------

You can interrupt a thread that is alive by using the interrupt() method.

This method invocation on a thread is just an indication to the thread that some other part of the program is trying to
draw its attention. It is up to the thread how it responds to the interruption.

Java implements the interruption mechanism using an interrupted status flag for every thread.

A thread could be in one of the two states when it is interrupted: running or blocked.

If a thread is interrupted when it is running, its interrupted status is set by the JVM. The running thread can check
its interrupted status by calling the Thread.interrupted() static method, which returns true if the current thread was
interrupted.
The call to the Thread.interrupted() method clears the interrupted status of a thread. That is, if you call this
method again on the same thread and if the first call returned true, the subsequent calls will return false, unless the
thread is interrupted after the first call but before the subsequent calls.

Threads Work in a Group
-----------------------

A thread is always a member of a thread group.
By default, the thread group of a thread is the group of its creator thread.

The JVM creates a thread group called main and a thread in this group called main, which is responsible for running
the main() method of the class at startup.

A thread group in a Java program is represented by an object of the java.lang.ThreadGroup class.

The getThreadGroup() method of the Thread class returns the reference to the ThreadGroup of a thread.

You can also create a thread group and place a new thread in that thread group. To place a new thread in your thread
group, you must use one of the constructors of the Thread class that accepts a ThreadGroup object as an argument.

Thread groups are arranged in a tree-like structure. A thread group can contain another thread group. The getParent()
method of the ThreadGroup class returns the parent thread group of a thread group. The parent of  the top-level thread
group is null.

The activeCount() method of the ThreadGroup class returns an estimate of the number of active threads in the group.

The enumerate() method of the ThreadGroup class can be used to get the threads in a thread group.
A thread group in a Java program can be used to implement a group-based policy that applies to all threads in a
thread group. For example, by calling the interrupt() method of a thread group, you can interrupt all threads in the
thread group.


