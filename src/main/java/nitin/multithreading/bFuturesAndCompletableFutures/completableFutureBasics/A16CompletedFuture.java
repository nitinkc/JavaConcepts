package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;

import java.util.concurrent.CompletableFuture;

public class A16CompletedFuture {
    public static void main(String[] args) {
        // Create a completed CompletableFuture with a predefined value
        CompletableFuture<String> completedFuture = CompletableFuture.completedFuture("Hello, World!");

        // Use the completed CompletableFuture
        CompletableFuture<String> stringCompletableFuture = completedFuture
                .thenApply(result -> {
                    // This block will be executed immediately with the precomputed result
                    return result + " - Processed";
                });

        System.out.println(stringCompletableFuture.join());

        Book book = Faker.instance().book();
        System.out.println(book.title() );

    }
}
