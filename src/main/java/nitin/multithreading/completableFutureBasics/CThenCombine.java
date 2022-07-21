package nitin.multithreading.completableFutureBasics;

import nitin.multithreading.completableFutureBasics.service.DataFetchService;

import java.util.concurrent.CompletableFuture;

import static com.utilities.MultiThreadUtility.delay;
import static com.utilities.MultiThreadUtility.logMessage;

public class CThenCombine {

    DataFetchService dataFetchService;

    public CThenCombine(DataFetchService dataFetchService){
        this.dataFetchService =  dataFetchService;
    }

    //Combining Two Completable Futures
    public CompletableFuture<String> fullNameService() {

        //All are independent Tasks
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

    //Four Completable Futures
    public CompletableFuture<String> fullNameWithGreetingAndGoodByesService() {

        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> dataFetchService.firstNameService());
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> dataFetchService.lastNameService());
        CompletableFuture<String> intro = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            logMessage("From intro Service");
            return "Hello!!";
        });

        //Longest Running task decides the end of the completable Futures
        CompletableFuture<String> extro = CompletableFuture.supplyAsync(() -> {
            delay(1100);
            logMessage("From extro Service");
            return ", Thank You!!";
        });

        CompletableFuture<String> fullNameCompletableFuture =
                    intro.thenCombine(firstName, (previous, current) -> {//previous is greeting, current is first name
                            return previous + " " + current;})
                        .thenCombine(lastName, (fn, ln) -> {
                            return new StringBuilder().append(fn).append(" ").append(ln).toString();})//Completion stage is the last name service.
                        .thenCombine(extro, (prev, curr) -> {
                            return prev+curr;
                        })
                      //  .thenApply(completeName -> completeName.toUpperCase())
                ;

        return fullNameCompletableFuture;
    }
}
