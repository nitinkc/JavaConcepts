package nitin.reactiveProgramming.reactorLib;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class R3MonoFromSupplier {
    public static void main(String[] args) {

        //JUST : Use only what the data is available already
        //Mono.just(nameRepo());

        //Will not be invoked until the subscriber subscribe to it. Lasy behaviour
        Mono<String> fromSupplier = Mono.fromSupplier(() -> nameRepo());
        Mono<String> fromCallable = Mono.fromCallable(() -> nameRepo());
        Mono<String> fromFuture = Mono.fromFuture(nameRepoCompletableFuture());

        fromSupplier.subscribe(name -> System.out.println(name));
        fromFuture.subscribe(name -> System.out.println(name));

        System.out.println("================================");
        //Mono from runnable (doesnt take in, doesnt take out), helpful in Notifying things
        Mono<Object> fromRunnable = Mono.fromRunnable(() -> System.out.println("Some time consuming Operations"));

        fromRunnable.subscribe(data -> System.out.println(data),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Process completed :: Sending emails")
        );

        Mono<Object> fromRunnable2 = Mono.fromRunnable(() -> System.out.println("Some time consuming Operations 2"));

        fromRunnable2.subscribe(data -> System.out.println(data),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Process completed 2 :: Sending emails")
        );
    }

    private static String nameRepo() {
        System.out.println("Fetching name : ");
        return Faker.instance().name().fullName();
    }

    private static CompletableFuture<String> nameRepoCompletableFuture() {
        System.out.println("Fetching name from Completable Future : ");
        return CompletableFuture.supplyAsync(() -> "From Comp fut :: " + Faker.instance().name().fullName());
    }
}
