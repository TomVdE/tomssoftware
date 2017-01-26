NEW

When a thread is created and its start method is not yet called

    Thread t = new SomeThreadClass();

RUNNABLE

When a thread is ready to run or running -> eligible for getting CPU time

BLOCKED

if thread is trying to enter (or re-enter) a synchronized method or block but the monitor is being used by another
thread

    - thread in the entry set waiting to acquire a monitor lock
    - thread in the wait set waiting to reacquire the monitor lock after waking up

WAITING

A thread can place itself a waiting state by calling one of following methods:

    wait()      to wait for a specific condition to hold.
                thread must own monitor's lock of object on which it calls wait()
                goes hand in hand with notify() and/or notifyAll()

    join()      method of the Thread class
                Thread calls this method when it wants to wait until the thread on which this method is called terminates

    park()      method of LockSupport class (java.util.concurrent.locks package)

TIMED-WAITING

A thread can place itself a timed-waiting state by calling one of following methods:

    sleep()         method of Thread class
    wait(long ms)   methods of the Object class

    join(long ms)   methods of the Thread class
    parkNanos(...)  methods of LockSupport
    parkUntil()     methods of LoclSupport

TERMINATED

A thread that has completed its execution.
When it exits its run() methods or its stop() method is called.

A terminated thread cannot transition to any other state.


Few handy methods:

    isAlive() method of a thread        to know if it is alive or terminated (after been started)
    getState() method of the thread     to get the state of a thread at any time

