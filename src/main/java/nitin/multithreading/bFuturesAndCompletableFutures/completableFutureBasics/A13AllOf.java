package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import static com.utilities.PerformanceUtility.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service.DataFetchService;

public class A13AllOf {
    public static void main(String[] args) {
        DataFetchService dataFetchService = new DataFetchService();

        startTimer();
        CompletableFuture<String> helloFuture =
                CompletableFuture.supplyAsync(() -> dataFetchService.greetingsService(3000));
        CompletableFuture<String> firstNameFuture =
                CompletableFuture.supplyAsync(() -> dataFetchService.firstNameService(2000));
        CompletableFuture<String> lastNameFuture =
                CompletableFuture.supplyAsync(() -> dataFetchService.lastNameService(1000));
        CompletableFuture<String> exclaim = CompletableFuture.supplyAsync(() -> "!!");
        stopTimer();
        resetTimer();

        List<CompletableFuture<String>> completableFutures =
                List.of(helloFuture, firstNameFuture, lastNameFuture, exclaim);
        CompletableFuture<Void> resultantCf =
                CompletableFuture.allOf(
                        completableFutures.toArray(
                                new CompletableFuture[completableFutures.size()]));

        CompletableFuture<List<String>> allFutureResults =
                resultantCf.thenApply(
                        t ->
                                completableFutures.stream()
                                        .map(CompletableFuture::join)
                                        .collect(Collectors.toList()));

        try {
            startTimer();
            System.out.println("Before Get");
            List<String> resultString = allFutureResults.get(); // Actual Execution of all methods
            System.out.println("After Get");

            stopTimer();
            resetTimer();

            System.out.println("Result - " + resultString);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static String getString(String str1, String str2) {
        return str1 + " " + str2;
    }
}
