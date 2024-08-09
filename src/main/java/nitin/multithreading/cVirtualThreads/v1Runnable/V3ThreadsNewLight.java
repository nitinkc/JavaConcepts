package nitin.multithreading.cVirtualThreads.v1Runnable;

import com.utilities.MultiThreadUtility;

public class V3ThreadsNewLight {
    public static void main(String[] args) throws InterruptedException {
        //Static method initialization
        var t1 = Thread.startVirtualThread(() -> task1());
        var t2 = Thread.startVirtualThread(() -> task2());

        //All Virtual Threads are always daemon threads,
        // don’t forget to call join() if you want to wait on the main thread.
        t1.join();
        t2.join();

        System.out.println("Main thread " + Thread.currentThread());
    }

    public static void task1() {
        int x = 90;
        System.out.println("entering task1 " + Thread.currentThread());
        MultiThreadUtility.delay(1000);
        System.out.println("exiting task1 " + Thread.currentThread() + " - Value of x = " + x);
    }

    public static void task2() {
        System.out.println("entering task2 " + Thread.currentThread());
        MultiThreadUtility.delay(5000);
        System.out.println("exiting task2 " + Thread.currentThread());
    }
}
