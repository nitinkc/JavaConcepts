package nitin.multithreading.completableFutureBasics;

import nitin.multithreading.completableFutureBasics.service.DataFetchService;

import java.util.concurrent.CompletableFuture;

import static com.utilities.MultiThreadUtility.logMessage;

public class CompletableFutureExceptionHandling {

    DataFetchService dataFetchService = new DataFetchService();

    public String async_call_exception_handle(){
        CompletableFuture<String> greetings = CompletableFuture.supplyAsync(() -> this.dataFetchService.greetingsService());
        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> this.dataFetchService.firstNameService());
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> this.dataFetchService.lastNameService());

        CompletableFuture<String> fullNameCompletableFuture =
                greetings
                        .handle((result, exception) -> {
                            logMessage("Result is " + result);
                            if(null != exception){
                                logMessage("Found Exception" + exception.getMessage());
                                return "ERROR Hi!!";
                            }else {
                                return result;
                            }
                        })
                        .thenCombine(firstName, (previous, current) -> {return previous + " " + current;})
                        .handle((result, exception) -> {
                            logMessage("Result is " + result);
                            if(null != exception){
                                logMessage("Found Exception" + exception.getMessage());
                                return "ERROR FN!!";
                            }else {
                                return result;
                            }
                        })
                        .thenCombine(lastName, (fn, ln) -> {return new StringBuilder().append(fn).append(" ").append(ln).toString();})//Completion stage is the last name service.
                        .thenApply(completeName -> completeName.toUpperCase());

        return fullNameCompletableFuture.join();
    }

    public String async_call_exception_exceptionally(){
        CompletableFuture<String> greetings = CompletableFuture.supplyAsync(() -> this.dataFetchService.greetingsService());
        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> this.dataFetchService.firstNameService());
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> this.dataFetchService.lastNameService());

        CompletableFuture<String> fullNameCompletableFuture =
                greetings
                        .exceptionally((exception) -> {
                            if(null != exception) {
                                logMessage("Found Exception" + exception.getMessage());
                            }
                            return "ERROR Hi!!";
                        })
                        .thenCombine(firstName, (previous, current) -> {return previous + " " + current;})
                        .exceptionally((exception) -> {
                            if(null != exception){
                                logMessage("Found Exception after greetings" + exception.getMessage());
                            }
                            return "ERROR FN!!";
                        })
                        .thenCombine(lastName, (fn, ln) -> {return new StringBuilder().append(fn).append(" ").append(ln).toString();})//Completion stage is the last name service.
                        .thenApply(completeName -> completeName.toUpperCase());

        return fullNameCompletableFuture.join();
    }
}
