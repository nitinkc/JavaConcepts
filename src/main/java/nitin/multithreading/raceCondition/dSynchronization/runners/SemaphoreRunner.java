package nitin.multithreading.raceCondition.dSynchronization.runners;

import nitin.multithreading.raceCondition.dSynchronization.IncrementTaskSemaphore;
import nitin.multithreading.raceCondition.dSynchronization.SharedCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreRunner {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();
        Semaphore semaphore = new Semaphore(1); // Semaphore with one permit

        // Create an ExecutorService with a fixed thread pool
        try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {

            // Submit 1000 tasks to the executor
            for (int i = 0; i < 1000; i++) {
                executorService.submit(new IncrementTaskSemaphore(sharedCounter, semaphore));
            }

            // Shut down the executor service and wait for tasks to complete
            executorService.shutdown();
            while (!executorService.isTerminated()) {
                // Wait for all tasks to complete
            }
        }

        System.out.println(STR."Final Counter: \{sharedCounter.getCounter()}");
    }
}