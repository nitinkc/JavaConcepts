package nitin.multithreading.asynchronousProgramming;

import java.util.concurrent.CompletableFuture;

public class Test {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        future.thenApply(num -> num * 2)
                .thenApply(num -> num + 1)
                .thenAccept(System.out::println);

        //Pipeline does not run until the complete is supplied a value
        future.complete(100); // Manually complete the future with the value 42

    }
}
