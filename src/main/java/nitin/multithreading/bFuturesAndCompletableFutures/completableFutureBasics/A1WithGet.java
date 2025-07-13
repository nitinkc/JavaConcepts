package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service.DataFetchService;

public class A1WithGet {

    public static void main(String[] args) {
        DataFetchService dataFetchService = new DataFetchService();
        System.out.println("main: " + Thread.currentThread());

        CompletableFuture<Void> voidCompletableFuture =
                CompletableFuture.supplyAsync(
                                () -> {
                                    System.out.println(
                                            "supplier: "
                                                    + Thread.currentThread()); // Runs in a separate
                                    // thread pool
                                    return dataFetchService.greetingsService(1_000);
                                })
                        .thenApply(String::toUpperCase)
                        .thenAccept(
                                greetings ->
                                        System.out.println(
                                                "Message received from supply Async: "
                                                        + greetings
                                                        + ": "
                                                        + Thread.currentThread()));

        try {
            voidCompletableFuture.get(); // Blocks the main thread until the supplyAsync is done
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            Thread.currentThread().interrupt(); // Preserve interruption status
        } catch (ExecutionException e) {
            System.out.println("Caught exception: " + e.getCause()); // Print actual cause
        }

        // Because of join, DONE will be printed after async call is done
        System.out.println("DONE: " + Thread.currentThread());
    }
}
