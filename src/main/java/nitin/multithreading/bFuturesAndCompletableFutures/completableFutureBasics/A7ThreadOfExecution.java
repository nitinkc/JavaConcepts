package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import static com.utilities.MultiThreadUtility.delay;
import static com.utilities.PerformanceUtility.*;

import java.util.concurrent.CompletableFuture;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service.DataFetchService;

public class A7ThreadOfExecution {
    public static void main(String[] args) {
        DataFetchService dataFetchService = new DataFetchService();
        System.out.println("main:: " + Thread.currentThread());
        System.out.println("++++++++++++++++++++++++ Synchronization Run ++++++++++++++++++++++++");
        // Takes total time equal to sum total of individual method times
        // total time = method1 + method2 + method3
        sequentialProgramRunningInOneThread(dataFetchService);

        System.out.println("++++++++++++++++++++++++ Async Run ++++++++++++++++++++++++");
        // Takes time based on the slowest method. total time = Max(method1, method2, method3) +
        // tiny extra processing time
        asyncRun(dataFetchService);
        System.out.println("main:: " + Thread.currentThread());

        System.out.println("++++++++++++++++++++++++ TEST ++++++++++++++++++++++++");
        test();
    }

    private static void test() {
        CompletableFuture<Double> future = getData();
        delay(1000); // delay

        future.thenAccept(data -> getPrintln(data));
        // May run in the main thread if all the executions are done,
        // or it may run in a different thread

        System.out.println("After printing Data");
        delay(1000); // delay
    }

    private static void sequentialProgramRunningInOneThread(DataFetchService dataFetchService) {
        // Example service, could be a DB Call or a REST Call to outside Service or anyService Call
        // (KafkaQueue, other messaging Queue)
        startTimer();
        String hello = dataFetchService.greetingsService(1000);
        String firstName = dataFetchService.firstNameService(1000);
        String lastName = dataFetchService.lastNameService(1000);
        stopTimer();

        System.out.println(hello + " " + firstName + " " + lastName);
        resetTimer();
    }

    private static void asyncRun(DataFetchService dataFetchService) {
        // May run in the main thread if all the executions are done,
        // or it may run in a different thread
        CompletableFuture<String> helloFuture =
                CompletableFuture.supplyAsync(() -> dataFetchService.greetingsService(1000));
        CompletableFuture<String> firstNameFuture =
                CompletableFuture.supplyAsync(() -> dataFetchService.firstNameService(1000));
        CompletableFuture<String> lastNameFuture =
                CompletableFuture.supplyAsync(() -> dataFetchService.lastNameService(1000));

        startTimer(); // Actual call to the pipeline
        System.out.println(
                helloFuture.join()
                        + " "
                        + firstNameFuture.join()
                        + " "
                        + lastNameFuture.join()); // Prefer join instead of GET
        stopTimer();
    }

    private static void getPrintln(Double data) {
        System.out.println("getPrintln: " + Thread.currentThread() + " data : " + data);
    }

    public static Double compute() {
        System.out.println("compute: " + Thread.currentThread());
        delay(1000);
        return 3.14;
    }

    public static CompletableFuture<Double> getData() {
        System.out.println("getData: " + Thread.currentThread());
        return CompletableFuture.supplyAsync(() -> compute());
    }
}
