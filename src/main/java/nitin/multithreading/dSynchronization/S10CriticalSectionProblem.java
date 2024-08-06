package nitin.multithreading.dSynchronization;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 1:55 AM.
 */
public class S10CriticalSectionProblem {
    public static void main(String[] args) {
        Account a = new Account();

        // Same Object is beng used by two Threads
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        t1.setName("T1");
        t2.setName("T2");
        t1.start();
        t2.start();

    }
}

class Account implements Runnable {
    // Shared in the heap Area, thus available to all
    int balance = 5;

    //Make the Run method Synchronized to place a lock
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            balance = balance + 1;
            System.out.println(Thread.currentThread().getName() + " Has Balance: " + balance);
        }
    }
}
