package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import static com.utilities.MultiThreadUtility.*;

import java.util.concurrent.CompletableFuture;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service.DataFetchService;

public class A0DefiningCompletableFuture {

    public static void main(String[] args) {
        DataFetchService dataFetchService = new DataFetchService();
        logMessage("From Main Thread");
        CompletableFuture<String> stringCompletableFuture =
                CompletableFuture.supplyAsync(() -> getData(dataFetchService));

        stringCompletableFuture.thenAccept(
                greetings -> logMessage("Message received from supply Async: " + greetings));

        delay(1000); // Introducing delays to let the completable future finish without using join
        // or get
        System.out.println("DONE");
        // stringCompletableFuture.get();// wait till Task Future is Completed (No Return data)
        delay(1000); // This delay forces the thread from supplier to run prior to ending the
        // program
    }

    private static String getData(DataFetchService dataFetchService) {
        logMessage("Inside getData : ");
        return dataFetchService.greetingsService(1000);
    }
}
