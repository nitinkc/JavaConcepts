package nitin.multithreading.asynchronousProgramming;

import nitin.multithreading.asynchronousProgramming.completableFutureBasics.service.DataFetchService;

import java.util.concurrent.CompletableFuture;

import static com.utilities.MultiThreadUtility.delay;

public class A0DefiningCompletableFuture {

    private static CompletableFuture<String> getStringCompletableFuture(DataFetchService dataFetchService) {
        return CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("supp: " + Thread.currentThread());//Runs in a separate thread pool
                    return dataFetchService.greetingsService(1000);
                });
    }

    public static void main(String[] args) {
        DataFetchService dataFetchService = new DataFetchService();

        System.out.println("main: " + Thread.currentThread());

        getStringCompletableFuture(dataFetchService)
                .thenAccept(greetings -> System.out.println("Message received from supply Async: "+greetings))
        ;

        //delay(1000);//Introducing delays to let the completable future finish without using join or get
        System.out.println("DONE");
        delay(1000);// This delay forces the thread from supplier to run prior to ending the program
    }
}