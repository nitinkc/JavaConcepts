package nitin.multithreading.raceCondition.dSynchronization;

import java.util.concurrent.Semaphore;

public class IncrementTaskSemaphore implements Runnable {
    private final SharedCounter sharedCounter;
    private final Semaphore semaphore;

    public IncrementTaskSemaphore(SharedCounter sharedCounter, Semaphore semaphore) {
        this.sharedCounter = sharedCounter;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); // Acquire the permit
            sharedCounter.increment();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Release the permit
        }
    }
}
