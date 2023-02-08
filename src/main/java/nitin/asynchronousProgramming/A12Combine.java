package nitin.asynchronousProgramming;

import java.util.concurrent.CompletableFuture;

import static com.utilities.MultiThreadUtility.delay;

public class A12Combine {
    public static void main(String[] args) {

        CompletableFuture<Double> radiusFuture = getRadius();

        radiusFuture
                //.thenApply(radius -> getArea(radius))//Returns a completable future, not the value of it, java.util.concurrent.CompletableFuture@7106e68e[Completed normally]
                .thenCompose(radius -> getArea(radius))
                .thenAccept(area -> System.out.println(area));
    }

    private static double computeWhenBothResolved(Double p, Double rad) {
        System.out.println("calculating Area once both are resolved");
        return p * rad * rad;
    }

    public static CompletableFuture<Double> getArea(Double radius){
        System.out.println("getting area");
        delay(1000);
        return CompletableFuture.supplyAsync(() -> Math.PI*radius*radius);//Returning a random number Asyncronously
    }

    public static CompletableFuture<Double> getRadius(){
        System.out.println("getting RADIUS");
        delay(3000);
        return CompletableFuture.supplyAsync(() -> 2.0);//Returning a random number Asyncronously
    }

}
