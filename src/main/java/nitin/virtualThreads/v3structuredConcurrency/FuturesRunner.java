package nitin.virtualThreads.v3structuredConcurrency;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import nitin.virtualThreads.v3structuredConcurrency.BlockingIOTasks.TaskResponse;

public class FuturesRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Main thread : Start : " + Thread.currentThread());
        BlockingIOTasks task = new BlockingIOTasks("LongTask1", 10, true);

        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
            Future<TaskResponse> taskFtr = service.submit(task);

            // do something for 5 secs and cancel main thread
            Thread.sleep(Duration.ofSeconds(5));
            taskFtr.cancel(true);
        }

        System.out.println("Main Thread : Complete: " + Thread.currentThread());
    }
}