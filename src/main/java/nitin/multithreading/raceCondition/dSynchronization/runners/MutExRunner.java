package nitin.multithreading.raceCondition.dSynchronization.runners;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import nitin.multithreading.raceCondition.dSynchronization.IncrementTaskMutex;
import nitin.multithreading.raceCondition.dSynchronization.SharedCounter;

public class MutExRunner {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        Lock lock = new ReentrantLock();

        // Create 1000 tasks to increment the counter
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(new IncrementTaskMutex(sharedCounter, lock), "Thread " + (i + 1));
            t.start();
        }

        // Wait for all threads to complete
        try {
            Thread.sleep(5000); // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter: " + sharedCounter.getCounter());
    }
}
