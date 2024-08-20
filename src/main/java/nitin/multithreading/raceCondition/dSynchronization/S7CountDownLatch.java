package nitin.multithreading.raceCondition.dSynchronization;

import com.utilities.MultiThreadUtility;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.utilities.MultiThreadUtility.logMessage;

/**
 * Created by Nitin Chaurasia on 12/5/15 at 10:39 PM.
 * <p>
 * Demonstrating
 */
public class S7CountDownLatch {
    public static void main(String[] args) {
        // Number of worker threads
        int numberOfWorkers = 3;

        // Create a CountDownLatch initialized with the number of worker threads
        CountDownLatch latch = new CountDownLatch(numberOfWorkers);

        // Create an ExecutorService with a fixed thread pool
        try (ExecutorService executor = Executors.newFixedThreadPool(numberOfWorkers)) {
            // Submit worker tasks to the executor
            for (int i = 1; i <= numberOfWorkers; i++) {
                final int workerId = i;
                executor.submit(() -> task(workerId, latch));
            }

            // Main thread waits until all worker threads have finished
            logMessage("Main thread is waiting for workers to finish.");
            try {
                latch.await();  // This will block until latch count reaches zero
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Main thread was interrupted while waiting.");
            }
            logMessage("All workers have finished. Main thread resumes.");
        } catch (Exception e) {
            System.out.println("An error occurred while creating the ExecutorService: " + e.getMessage());
        }
    }

    private static void task(int workerId, CountDownLatch latch) {
        try {
            logMessage("Worker " + workerId + " is performing the task.");
            // Simulate task duration
            Thread.sleep((long) (Math.random() * 2000));
            logMessage("Worker " + workerId + " has finished the task.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Worker " + workerId + " was interrupted.");
        } finally {
            // Decrement the count of the latch
            latch.countDown();
        }
    }
}