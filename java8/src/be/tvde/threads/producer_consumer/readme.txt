The producer/consumer is a typical thread synchronization problem that uses the wait() and notify() methods.



The Buffer class needs some explanation. It has two instance variables:

    private int data
    private boolean empty

The producer uses the data instance variable to store the new data.
The consumer uses it to read the data.
The empty instance variable is used as an indicator whether the buffer is empty or not.
In the constructor, it is initialized to true indicating that the new buffer is empty.

It has two synchronized methods: produce() and consume().
Both methods are declared synchronized because the goal is to protect the Buffer object to be used by multiple threads
concurrently. If the producer is producing new data by calling the produce() method, the consumer must wait to consume
the data until the producer is done and vice versa.
The producer thread calls the produce() method, passing the newly generated data to it. However, before the new data is
stored in the data instance variable, the producer makes sure that the buffer is empty. If the buffer is not empty, it
calls the this.wait() method to place itself in the wait set of the buffer object until the consumer notifies it using
the this.notify() method inside the consume() method. Once the producer thread detects that the buffer is empty, it
stores the new data in the data instance variable, sets the empty flag to false, and calls this.notify() to wake up the
consumer thread in the wait set to consume the data. At the end, it also prints a message on the console that data has
been produced.

The consume() method of the Buffer class is similar to its counterpart, the produce() method. The only difference is
that the consumer-thread calls it and it performs a logic just opposite to the produce() method.

The Producer and Consumer classes inherit the Thread class. They override the run() method of the Thread class. Both of
them accept an object of the Buffer class in their constructors to use it in their run() method. The Producer class
generates a random integer in its run() method inside an infinite loop and keeps writing it to the buffer. The Consumer
class keeps consuming data from the buffer in an infinite loop. The ProducerConsumerTest class creates all three objects
 (a buffer, a producer, and a consumer) and starts the producer and consumer threads.

