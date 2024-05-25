package nitin.multithreading.asynchronousProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

import static com.utilities.MultiThreadUtility.delay;

public class A8ChangingThreadPool {
    public static void main(String[] args) {
        System.out.println("m: " + Thread.currentThread());

        CompletableFuture<Double> future = getData();
        delay(1000);//delay

        future.thenAccept(data -> getPrintln(data));
        // May run in the main thread if all the executions are done,
        // or it may run in a different thread

        System.out.println("After printing Data");
        delay(1000);//delay
        System.out.println("m: " + Thread.currentThread());

    }

    public static CompletableFuture<Double> getData() {
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

        ForkJoinPool pool = new ForkJoinPool(10);
        System.out.println("d: " + Thread.currentThread());
        return CompletableFuture.supplyAsync(() -> compute(), pool);
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
