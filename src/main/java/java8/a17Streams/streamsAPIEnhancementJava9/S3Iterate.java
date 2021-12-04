package java8.a17Streams.streamsAPIEnhancementJava9;

import java.util.stream.Stream;
/**
 * Created by nitin on Sunday, January/26/2020 at 10:29 PM
 */
public class S3Iterate {
    public static void main(String[] args) {

        // It takes an initial value and a function that provides next value,
        // Runs infinitely, Use limit() to put an upper cap
        Stream
                .iterate(1,x->x+3)
                .limit(5)
                .forEach(System.out::println);

        // Iterate with 3 Arguments
        Stream
                .iterate(1, x -> x < 10, x -> x+1)
                .forEach(x -> System.out.println(x));


    }
}
