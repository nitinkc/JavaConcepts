package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import com.utilities.MultiThreadUtility;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class   A1Intro {
    public static void main(String[] args) {
        //eg1();

        eg2();
        //eg3();
    }

    private static void eg1() {
        System.out.println("main thread1: " + Thread.currentThread());

        CompletableFuture
                .supplyAsync(() -> {//Runs in a separate thread and releases it
                    System.out.println("supplier: " + Thread.currentThread());
                    return Math.PI;
                })
                .thenAccept(data -> System.out.println("Message received from supply Async: " + data));

        System.out.println("main thread2: " + Thread.currentThread());
    }

    private static void eg2() {
        getData()
                .thenAccept(data -> System.out.println(data))
                .thenRun(() -> System.out.println("Can continue from this on..."))
                .thenRun(() -> System.out.println("this never ends"))
                .thenRun(() -> System.out.println("tap on, get data... get out..."));
    }

    private static void eg3() {
        try {
            System.out.println(getData().get());//BAD IDEA, forces exception handling, it's a BLOCKING CALL for forGET
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<Integer> generateRand() {
        return CompletableFuture.supplyAsync(
                () -> RandomUtils.nextInt(1, 10));//Returning a random number Asyncronously
    }

    public static CompletableFuture<Double> getData() {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("Getting the data......");
                    MultiThreadUtility.delay(1000);//Try commenting and see how it's changing the thread
                    return 22.7;
                });
    }
}
