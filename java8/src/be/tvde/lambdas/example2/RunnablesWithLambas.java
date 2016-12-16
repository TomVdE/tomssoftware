package be.tvde.lambdas.example2;

/**
 * Created by tomvde on 28/11/2016.
 */
public class RunnablesWithLambas {

    public static void main(String[] args) throws InterruptedException {
        //Runnable implemented as annonymous class
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
        t.join();
        System.out.println(Thread.currentThread().getName());

        //Runnable implemented as lamba expression
        Runnable runnableLamba = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
            }
        };
        Thread t1 = new Thread(runnableLamba);
        t1.start();
        t1.join();
        System.out.println(Thread.currentThread().getName());
    }
}
