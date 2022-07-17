package nitin.multithreading.completableFutureBasics;

import nitin.multithreading.completableFutureBasics.service.DataFetchService;

import java.util.concurrent.CompletableFuture;

public class CThenCombine {

    DataFetchService dataFetchService;

    public CThenCombine(DataFetchService dataFetchService){
        this.dataFetchService =  dataFetchService;
    }

    //Two Completable Futures
    public CompletableFuture<String> fullNameService() {

        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> dataFetchService.firstNameService());
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> dataFetchService.lastNameService());

        CompletableFuture<String> fullNameCompletableFuture = firstName.thenCombine(lastName, (fn, ln) -> {
            return new StringBuilder().append(fn).append(" ").append(ln).toString();})//Completion stage is the last name service.
                .thenApply(completeName -> completeName.toUpperCase());

        return fullNameCompletableFuture;
    }

    //Three Completable Futures
    public CompletableFuture<String> fullNameWithGreetingService() {

        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> dataFetchService.firstNameService());
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> dataFetchService.lastNameService());
        CompletableFuture<String> greetings = CompletableFuture.supplyAsync(() -> {
            return "Hello!!";
        });

        CompletableFuture<String> fullNameCompletableFuture =
                greetings.thenCombine(firstName, (previous, current) -> {
                    return previous + " " + current;})
                .thenCombine(lastName, (fn, ln) -> {
                    return new StringBuilder().append(fn).append(" ").append(ln).toString();})//Completion stage is the last name service.
                .thenApply(completeName -> completeName.toUpperCase());

        return fullNameCompletableFuture;
    }
}
