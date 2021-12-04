package java8.a17Streams.streamsAPIEnhancementJava9;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nitin on Sunday, January/26/2020 at 10:42 PM
 */
public class S4OfNullable {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", null, "D", null, "F");

        // First way of avoiding NullPointerException
        list.stream()
                .filter(object -> object != null)
                .map(str -> str.toLowerCase())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // Use of FlatMap with ofNullable to avoid null pointer exception
        list.stream()
                .flatMap(object -> Stream.ofNullable(object))
                .map(str -> str.toLowerCase())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
