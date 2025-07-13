package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import java.util.concurrent.CompletableFuture;

public class A4Complete {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        // Establish the pipeline
        future.thenApply(num -> num * 2)
                .thenApply(num -> num + 1)
                .thenAccept(System.out::println)
                .thenRun(() -> System.out.println("Continue on..."));

        // Pipeline does not run until the complete is supplied a value
        future.complete(100); // Manually complete the future with the value 42
    }
}
