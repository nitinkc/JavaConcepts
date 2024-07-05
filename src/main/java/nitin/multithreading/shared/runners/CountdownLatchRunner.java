package nitin.multithreading.shared.runners;

import nitin.multithreading.shared.IncrementTaskCountDownLatch;
import nitin.multithreading.shared.SharedCounter;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchRunner {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        CountDownLatch latch = new CountDownLatch(1000); // CountDownLatch with initial count

        // Create 1000 tasks to increment the counter
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(new IncrementTaskCountDownLatch(sharedCounter, latch), "Thread " + (i + 1));
            t.start();
        }

        // Wait for all threads to complete
        try {
            latch.await(); // Wait until all tasks complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter: " + sharedCounter.getCounter());
    }
}
