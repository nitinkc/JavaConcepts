package nitin.multithreading.asynchronousProgramming;

import nitin.multithreading.asynchronousProgramming.completableFutureBasics.service.DataFetchService;

import java.util.concurrent.CompletableFuture;

import static com.utilities.MultiThreadUtility.logShortMessage;

public class A5CompletableFutureExceptionHandling {

    DataFetchService dataFetchService = new DataFetchService();

    public String async_call_exception_handle() {
        CompletableFuture<String> greetings = CompletableFuture.supplyAsync(() -> this.dataFetchService.greetingsService(1000));
        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> this.dataFetchService.firstNameService(1000));
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> this.dataFetchService.lastNameService(1000));

        CompletableFuture<String> fullNameCompletableFuture =
                greetings
                        .handle((result, exception) -> {
                            logShortMessage("Result is " + result);
                            if (null != exception) {
                                logShortMessage("Found Exception" + exception.getMessage());
                                return "ERROR Hi!!";
                            } else {
                                return result;
                            }
                        })
                        .thenCombine(firstName, (previous, current) -> {
                            return previous + " " + current;
                        })
                        .handle((result, exception) -> {
                            logShortMessage("Result is " + result);
                            if (null != exception) {
                                logShortMessage("Found Exception" + exception.getMessage());
                                return "ERROR FN!!";
                            } else {
                                return result;
                            }
                        })
                        .thenCombine(lastName, (fn, ln) -> {
                            return fn + " " + ln;
                        })//Completion stage is the last name service.
                        .thenApply(completeName -> completeName.toUpperCase());

        return fullNameCompletableFuture.join();
    }

    public String async_call_exception_exceptionally() {
        CompletableFuture<String> greetings = CompletableFuture.supplyAsync(() -> this.dataFetchService.greetingsService(1000));
        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> this.dataFetchService.firstNameService(1000));
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> this.dataFetchService.lastNameService(1000));

        CompletableFuture<String> fullNameCompletableFuture =
                greetings
                        .exceptionally((exception) -> {
                            if (null != exception) {
                                logShortMessage("Found Exception" + exception.getMessage());
                            }
                            return "ERROR Hi!!";
                        })
                        .thenCombine(firstName, (previous, current) -> {
                            return previous + " " + current;
                        })
                        .exceptionally((exception) -> {
                            if (null != exception) {
                                logShortMessage("Found Exception after greetings" + exception.getMessage());
                            }
                            return "ERROR FN!!";
                        })
                        .thenCombine(lastName, (fn, ln) -> {
                            return fn + " " + ln;
                        })//Completion stage is the last name service.
                        .thenApply(completeName -> completeName.toUpperCase());

        return fullNameCompletableFuture.join();
    }
}
