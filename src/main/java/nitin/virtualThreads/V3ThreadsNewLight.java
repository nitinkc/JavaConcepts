package nitin.virtualThreads;

import com.utilities.MultiThreadUtility;

public class V3ThreadsNewLight {
    public static void main(String[] args) {
        Thread.startVirtualThread(() -> task1());
        Thread.startVirtualThread(() -> task2());

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
        MultiThreadUtility.delay(1000);
        System.out.println("exiting task2 " + Thread.currentThread());
    }
}
