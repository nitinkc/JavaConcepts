package nitin.multithreading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IOBoundOperations {
    private static final int NUMBER_OF_TASKS = 100_000;

    public static void main(String[] args) {
        System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        performTask();
        System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);
    }

    private static void performTask() {
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                executorService.submit(IOBoundOperations::blockingIoOperation);
            }
        }
    }

    // Simulates a long blocking IO
    private static void blockingIoOperation() {
        String unit = "MB";
        long bytesInMb =  (1024*1024);
        Runtime runtime = Runtime.getRuntime();

        //int sleepTime = 10 + new Random().nextInt(991); // 10 to 1000 ms
        int sleepTime = 1000;
        System.out.println("Executing a blocking task from thread: " + Thread.currentThread() + " sleeping : " + sleepTime + "ms");
        System.out.println("Available memory when task created: " + runtime.freeMemory()/bytesInMb + unit);

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
