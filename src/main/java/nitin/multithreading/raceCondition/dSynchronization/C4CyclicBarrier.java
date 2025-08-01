package nitin.multithreading.raceCondition.dSynchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Created by Nitin C on 12/5/2015. */
public class C4CyclicBarrier {
    int i = 0;

    public static void main(String[] args) {
        // Number of threads that need to wait at the barrier
        final int numThreads = 3;

        // creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
        final CyclicBarrier cb =
                new CyclicBarrier(
                        numThreads,
                        (() -> {

                            // This task will be executed once all thread reaches barrier
                            System.out.println("All parties are arrived at barrier, lets play");
                        }));

        // starting each of thread
        Thread t1 = new Thread(new Task(cb), "Thread 1");
        Thread t2 = new Thread(new Task(cb), "Thread 2");
        Thread t3 = new Thread(new Task(cb), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

    // Runnable task for each thread
    private static class Task implements Runnable {

        private final CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
                    barrier.await();
                    System.out.println(
                            Thread.currentThread().getName() + " has crossed the barrier");
                    barrier.await();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(C4CyclicBarrier.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(C4CyclicBarrier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
