package nitin.multithreading.dSynchronization;

/**
 * Created by Nitin Chaurasia on 12/6/15 at 6:14 PM.
 * <p>
 * Synchronize acquire Locks on the Object and not on the method. Thus If one Lock is acquired by
 * thread t1 for method m1, no other threads are allowed to execute even the non-sync method m3.
 */
public class S0SynchBasics {
    public static void main(String[] args) throws InterruptedException {
        Basics basics = new Basics();

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 started.");
            basics.m1();
            basics.m3();
            System.out.println("Thread 1 finished.");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 started.");
            basics.m2();
            basics.m3();
            System.out.println("Thread 2 finished.");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class Basics {
    public synchronized void m1() {
        System.out.println("From M1... Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate time-consuming operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void m2() {
        System.out.println("From M2... Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate time-consuming operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void m3() {
        System.out.println("From M3... Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Simulate time-consuming operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
