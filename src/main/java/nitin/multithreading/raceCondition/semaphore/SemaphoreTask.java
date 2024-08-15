package nitin.multithreading.raceCondition.semaphore;

import java.util.concurrent.Semaphore;

import static com.utilities.MultiThreadUtility.logShortMessage;

public class SemaphoreTask {
    private String name;
    private boolean acquirePermit;
    private static final int PERMITS = 1; // Number of permits available
    private static Semaphore semaphore = new Semaphore(PERMITS);

    SemaphoreTask(String name, boolean acquirePermit) {
        this.name = name;
        this.acquirePermit = acquirePermit;
    }

    void runTask() {
        try {
            if (acquirePermit) {
                logShortMessage(name + " trying to acquire permit...");
                semaphore.acquire(); // Acquire permit
                logShortMessage(name + " acquired permit.");
                Thread.sleep(2000); // Simulate some work
                logShortMessage(name + " releasing permit.");
                semaphore.release(); // Release permit
                logShortMessage(name + " released permit.");
            } else {
                logShortMessage(name + " trying to release permit...");
                semaphore.release(); // Release permit even if it didn't acquire it
                logShortMessage(name + " released permit.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
