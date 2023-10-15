package nitin.asynchronousProgramming;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.utilities.MultiThreadUtility.delay;

public class A1Intro {
    public static void main(String[] args) {
        System.out.println("m: " + Thread.currentThread());
        CompletableFuture
                .supplyAsync(() -> {//Runs in a separate thread and releases it
                    System.out.println("supp: " + Thread.currentThread());
                    return Math.PI;
                })
                .thenAccept(data -> System.out.println("Message received from supply Async: "+data));

        delay(1000);



        getData()
                .thenAccept(data -> System.out.println(data))
                .thenRun(() -> System.out.println("Can continue from this on..."))
                .thenRun(() -> System.out.println("this never ends"))
                .thenRun(() -> System.out.println("tap on, get data... get out..."));

        try {
            System.out.println(getData().get());//BAD IDEA, forces exception handling, it's a BLOCKING CALL for forGET
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<Integer> generateRand(){
        return CompletableFuture.supplyAsync(
                () -> RandomUtils.nextInt(1,10));//Returning a random number Asyncronously
    }

    public static CompletableFuture<Double> getData(){
        return CompletableFuture.supplyAsync(
                () -> 22.7);//Returning a random number Asyncronously
    }
}
