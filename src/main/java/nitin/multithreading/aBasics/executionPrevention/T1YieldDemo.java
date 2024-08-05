package nitin.multithreading.aBasics.executionPrevention;

// To call the ThreadByRunnable Class for reusing multiple times

import nitin.multithreading.aBasics.aPlatformThreads.ThreadByRunnable;

/**
 * Created by Nitin Chaurasia on 12/2/15 at 11:25 PM.
 * <p>
 * Pause current executing threads, giving chance to remaining
 * waiting Threads OF SAME PRIORITY.
 * <p>
 * If no waiting Threads, or all threads have lower Priority
 * Then Same thread will continue execution.
 */

public class T1YieldDemo {
    public static void main(String[] args) {
        ThreadByRunnable tr = new ThreadByRunnable();
        Thread t = new Thread(tr);

        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("From Main: " + i);
        }
    }

}

class ThreadYield implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Thread.yield();
            System.out.println("Child Thread: " + i);
        }
    }
}



