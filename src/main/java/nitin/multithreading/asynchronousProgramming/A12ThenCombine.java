package nitin.multithreading.asynchronousProgramming;

import nitin.multithreading.asynchronousProgramming.completableFutureBasics.service.DataFetchService;

import java.util.concurrent.CompletableFuture;

import static com.utilities.MultiThreadUtility.*;

public class A12ThenCombine {

    static DataFetchService dataFetchService;

    /**
     * Completion stage method
     * used to combine Independent Completable Futures
     * Takes two arguments
     * CompletionStage, BiFunction
     * Returns a CompletableFuture
     *
     * @param args
     */
    public static void main(String[] args) {
        dataFetchService = new DataFetchService();

        //CompletableFuture<String> future2 = fullNameService();
        //CompletableFuture<String> future3 = fullNameWithGreetingService();
        CompletableFuture<String> future4 = fullNameWithGreetingAndGoodByesService();

        //future2.thenAccept(data -> System.out.println(data)).join();
        //future3.thenAccept(data -> System.out.println(data)).join();

        System.out.println("--------------------------");
        future4.thenAccept(data -> System.out.println(data)).join();
        System.out.println("--------------------------");
    }

    //Combining Two Completable Futures
    public static CompletableFuture<String> fullNameService() {

        //All are independent Tasks
        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> dataFetchService.firstNameService(1000));
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> dataFetchService.lastNameService(1000));

        CompletableFuture<String> fullNameCompletableFuture =
                firstName
                        .thenCombine(lastName, (fn, ln) -> getAppendedString(fn, ln))//Completion stage is the last name service.
                        .thenApply(completeName -> completeName.toUpperCase());

        return fullNameCompletableFuture;
    }

    //Three Completable Futures
    public static CompletableFuture<String> fullNameWithGreetingService() {

        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> dataFetchService.firstNameService(1000));
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> dataFetchService.lastNameService(1000));
        CompletableFuture<String> greetings = CompletableFuture.supplyAsync(() -> {
            return "Hello!!";
        });

        CompletableFuture<String> fullNameCompletableFuture =
                greetings.thenCombine(firstName, (previous, current) -> {
                            return previous + " " + current;
                        })
                        .thenCombine(lastName, (fn, ln) -> {
                            return fn + " " + ln;
                        })//Completion stage is the last name service.
                        .thenApply(completeName -> completeName.toUpperCase());

        return fullNameCompletableFuture;
    }

    //Four Completable Futures
    public static CompletableFuture<String> fullNameWithGreetingAndGoodByesService() {

        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> dataFetchService.firstNameService(1000));
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> dataFetchService.lastNameService(1000));

        CompletableFuture<String> intro = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            logMessage("From intro Service");
            return "Hello!!";
        });

        //Longest Running task decides the end of the completable Futures
        CompletableFuture<String> extro = CompletableFuture.supplyAsync(() -> {
            delay(1100);
            logShortMessage("From extro Service");
            return ", Thank You!!";
        });

        CompletableFuture<String> fullNameCompletableFuture =
                intro.thenCombine(firstName, (previous, current) -> getAppendedString(previous, current)) //previous is greeting, current is first name
                        .thenCombine(lastName, (fn, ln) -> getAppendedString(fn, ln))//Completion stage is the last name service.
                        .thenCombine(extro, (prev, curr) -> prev + curr)
                        .thenApply(completeName -> completeName.toUpperCase());

        return fullNameCompletableFuture;
    }

    private static String getAppendedString(String str1, String str2) {
        return str1 + " " + str2;
    }
}
