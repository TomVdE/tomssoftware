package be.tvde.threads;


/**
 * Created by tomvde on 3/01/2017.
 */
public class BalanceUpdateSynchronized {

    private static int balance = 100;

    public static void main(String [] args) {
        startBalanceUpdateThread();
        startBalanceMonitorThread();
    }

    private static void startBalanceMonitorThread() {
        Thread t = new Thread(()-> {
            while (true) {
                monitorBalance();
            }
        });
    }

    private static synchronized void monitorBalance() {
        int b = balance;

        if (b!=100) {
            System.out.println("Balance changed: " + b);
            System.exit(1);
        }
    }

    private static void startBalanceUpdateThread() {
        Thread t = new Thread(() -> {
            while (true) {
                updateBalance();
            }
        });
    }

    private static synchronized void updateBalance() {
        balance = balance + 10;
        balance = balance - 10;
    }
}
