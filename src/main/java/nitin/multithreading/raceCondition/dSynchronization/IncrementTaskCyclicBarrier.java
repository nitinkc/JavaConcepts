package nitin.multithreading.raceCondition.dSynchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class IncrementTaskCyclicBarrier implements Runnable {
    private final SharedCounter sharedCounter;
    private final CyclicBarrier barrier;

    public IncrementTaskCyclicBarrier(SharedCounter sharedCounter, CyclicBarrier barrier) {
        this.sharedCounter = sharedCounter;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        sharedCounter.increment();
        try {
            barrier.await(); // Wait at the barrier
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}