package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import static com.utilities.MultiThreadUtility.delay;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A8ChangingThreadPool {
    /* In Spring properties yml, more arguments to Constructor can be passed.
    spring:
      task:
        execution:
          pool:
            coreSize: 10
            maxSize: 400
            keepAlive: 60s
            allowCoreThreadTimeout: true
     */
    public static void main(String[] args) {
        System.out.println("m: " + Thread.currentThread());
        // ForkJoinPool pool = new ForkJoinPool(10);
        ExecutorService pool = Executors.newCachedThreadPool();
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> compute(), pool);
        CompletableFuture<Double> doubleCompletableFuture =
                future.thenApplyAsync(data -> data * 2, pool);
        delay(2000);
        CompletableFuture<Void> voidCompletableFuture =
                doubleCompletableFuture.thenAcceptAsync(data -> getPrintln(data), pool);
        // May run in the main thread if all the executions are done,
        // or it may run in a different thread

        System.out.println("After printing Data");
        delay(1000); // delay
        System.out.println("m: " + Thread.currentThread());

        pool.close();
    }

    public static Double compute() {
        System.out.println("c: " + Thread.currentThread());
        delay(1000);
        return 3.14;
    }

    private static void getPrintln(Double data) {
        System.out.println("p: " + Thread.currentThread() + " data : " + data);
    }
}
