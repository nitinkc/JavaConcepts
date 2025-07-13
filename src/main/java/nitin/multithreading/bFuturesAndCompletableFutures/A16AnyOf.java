package nitin.multithreading.bFuturesAndCompletableFutures;

import com.github.javafaker.Faker;
import java.util.concurrent.CompletableFuture;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service.DataFetchService;

public class A16AnyOf {
    public static void main(String[] args) {
        DataFetchService dataFetchService = new DataFetchService();
        // Tasks we want to run in parallel
        var future1 =
                CompletableFuture.supplyAsync(
                        () -> dataFetchService.microTask("Harry Potter", 2, true));
        var future2 =
                CompletableFuture.supplyAsync(
                        () -> dataFetchService.microTask("Ron Weasley", 5, true));
        var future3 =
                CompletableFuture.supplyAsync(
                        () -> dataFetchService.microTask("Hermione Granger", 6, true));
        var future4 =
                CompletableFuture.supplyAsync(
                        () ->
                                dataFetchService.microTask(
                                        Faker.instance().harryPotter().character(), 1, true));

        // Returns a CompletableFuture which completes when any of the 4 futures complete
        // The remaining tasks are not cancelled
        CompletableFuture.anyOf(future1, future2, future3, future4)
                .thenAccept(
                        result -> {
                            System.out.println("Handling Accept :: " + result);
                        })
                .exceptionally(
                        throwable -> {
                            System.out.println("Handling Failure :: " + throwable);
                            return null;
                        })
                .join();
    }
}
