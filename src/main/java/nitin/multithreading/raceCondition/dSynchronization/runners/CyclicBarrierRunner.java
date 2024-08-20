package nitin.multithreading.raceCondition.dSynchronization.runners;

import nitin.multithreading.raceCondition.dSynchronization.IncrementTaskCyclicBarrier;
import nitin.multithreading.raceCondition.dSynchronization.SharedCounter;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRunner {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        CyclicBarrier barrier = new CyclicBarrier(1000, () -> {
            System.out.println("All threads reached the barrier");
        });

        // Create 1000 tasks to increment the counter
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(new IncrementTaskCyclicBarrier(sharedCounter, barrier), "Thread " + (i + 1));
            t.start();
        }
    }
}
