package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import java.util.concurrent.CompletableFuture;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service.DataFetchService;

public class A15AllOfWithWhenComplete {
    static DataFetchService dataFetchService = new DataFetchService();

    public static void main(String[] args) {
        // Tasks we want to run in parallel

        // Let's run all of them in parallel
        var future1 = CompletableFuture.supplyAsync(() -> dataFetchService.greetingsService(1000));
        var future2 = CompletableFuture.supplyAsync(() -> dataFetchService.firstNameService(1000));
        var future3 = CompletableFuture.supplyAsync(() -> dataFetchService.lastNameService(1000));
        var future4 = dataFetchService.futureName("Harry Potter");

        // Returns a CompletableFuture which completes when all 4 futures are completed
        // Use whenComplete to handle completion
        CompletableFuture.allOf(future1, future2, future3, future4)
                .whenComplete(
                        (Void, throwable) -> {
                            if (throwable == null) {
                                try {
                                    // Retrieve results from all future
                                    // Combine results
                                    String combinedResult =
                                            STR."\{
                                                    future1.get()} \{
                                                    future2.get()} \{
                                                    future3.get()} \{
                                                    future4.get()}";
                                    System.out.println("Combined result: " + combinedResult);
                                } catch (Exception e) {
                                    // Handle exceptions from get() calls
                                    System.err.println(
                                            "An error occurred while retrieving results: "
                                                    + e.getMessage());
                                }
                            } else {
                                // Handle exception from the CompletableFuture
                                System.err.println("An error occurred: " + throwable.getMessage());
                            }
                        })
                .join();
    }
}
