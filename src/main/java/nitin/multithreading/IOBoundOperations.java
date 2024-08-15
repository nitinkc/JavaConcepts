package nitin.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IOBoundOperations {
    private static final int NUMBER_OF_TASKS = 1000;

    public static void main(String[] args) {
        System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                executorService.submit(IOBoundOperations::blockingIoOperation);
            }
        }
        System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);
    }

    // Simulates a long blocking IO
    private static void blockingIoOperation() {
        System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
