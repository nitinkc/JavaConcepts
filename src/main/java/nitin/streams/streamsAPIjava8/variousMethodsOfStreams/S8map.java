package nitin.streams.streamsAPIjava8.variousMethodsOfStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class S8map {
    public static void main(String[] args) {
        Stream<String> listStream = Stream.of("Nitin", "Nidhi", "Niti");
        List<Integer> x = new ArrayList<>();

        // Lambda Expression
        listStream
                .flatMap(a -> Stream.of(a.toLowerCase(), a.length(), a.toUpperCase()))
                .forEach(b -> System.out.println(b));

        //The same is written in method reference
        //list.map(String::length).forEach(System.out::print);
    }
}
