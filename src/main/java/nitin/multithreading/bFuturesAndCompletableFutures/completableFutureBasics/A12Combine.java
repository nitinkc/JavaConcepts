package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import java.util.concurrent.CompletableFuture;

public class A12Combine {
    public static void main(String[] args) {
        CompletableFuture<Double> radiusFuture =
                CompletableFuture.supplyAsync(() -> 1.0); // Returning a random number Asyncronously
        radiusFuture
                // .thenApply(radius ->  CompletableFuture.supplyAsync(() ->
                // calculateArea(radius)))//Returns a completable future, not the value of it,
                // java.util.concurrent.CompletableFuture@7106e68e[Completed normally]
                .thenCompose(radius -> CompletableFuture.supplyAsync(() -> calculateArea(radius)))
                .thenAccept(area -> System.out.println(area));
    }

    private static Double calculateArea(Double radius) {
        return 3.14 * radius * radius;
    }

    private static double computeWhenBothResolved(Double p, Double rad) {
        System.out.println("calculating Area once both are resolved");
        return p * rad * rad;
    }
}
