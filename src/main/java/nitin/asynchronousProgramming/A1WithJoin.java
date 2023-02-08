package nitin.asynchronousProgramming;

import nitin.asynchronousProgramming.completableFutureBasics.service.DataFetchService;

import java.util.concurrent.CompletableFuture;

public class A1WithJoin {

    public static void main(String[] args) {
        DataFetchService dataFetchService = new DataFetchService();

        System.out.println("main: " + Thread.currentThread());

        CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("supp: " + Thread.currentThread());//Runs in a separate thread pool
                    return dataFetchService.greetingsService(1000);
                })
                .thenApply(String::toUpperCase)
                .thenAccept(greetings -> System.out.println("Message received from supply Async: "+greetings + ": " + Thread.currentThread()))
                .join()//Blocks the main thread until the supplyAsync is done
        ;

        //Becaue of join, DONE will be printed after async call is done
        System.out.println("DONE: " + Thread.currentThread());
    }
}
