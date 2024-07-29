package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.utilities.MultiThreadUtility.delaySeconds;

public class A3Pipeline {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //intro();
        establishAndrunPipeline();
    }

    private static void establishAndrunPipeline() {
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(() -> getData());
        //If there is an exception, the future will go into REJECT state
        CompletableFuture<Void> voidCompletableFuture = completableFuture
                .thenApply(x -> x.intValue())
                .thenApply(x -> Double.parseDouble(String.valueOf(x))) //If there is an exception, handle with exceptionally
                .thenApply(x -> 2 / x)
                .exceptionally(throwable -> {
                    System.out.println("Exception received " + throwable);
                    return Double.valueOf(-1);
                })
                .thenAccept(x -> System.out.println("rtr " + x))//Behaves like ForEach, but not a reduction operation.
                .thenRun(() -> System.out.println("Can continue"))
                .thenRun(() -> System.out.println("Even further"));

        delaySeconds(5);
        voidCompletableFuture.join();//Holding the main thread from quitting before spitting out the logs
        System.out.println("Done");
    }

    private static void intro() {
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(() -> getData());

        CompletableFuture<Void> voidCompletableFuture = completableFuture
                .thenApply(num -> num * 100)//like Map
                .thenAccept(data -> System.out.println(data))//forEach, like reduction operation
                .thenRun(() -> System.out.println("Job Done!!"));//Still continue with the CompletableFuture

        voidCompletableFuture.join();
    }

    public static Double getData() {
        delaySeconds(2);

        return Math.PI;
    }
}
