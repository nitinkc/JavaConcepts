package nitin.streams.streamsAPIjava8.variousMethodsOfStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nitin on Sunday, January/26/2020 at 8:21 PM
 * TakeWhile runs until the first false/negative condition is met
 * DropWhile runs from the first negative condition is met.
 */
public class S2DropWhile {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three", "four", "circuit breaker", "five", "six", "seven");

        List<String> takeWhileList = list
                .stream()
                .takeWhile(str -> str.length() < 7)
                //.takeWhile(str -> str.equals("one"))
                .collect(Collectors.toList());

        System.out.println(takeWhileList);

        List<String> dropWhileList = list
                .stream()
                .dropWhile(str -> str.length() < 7)
                .collect(Collectors.toList());

        System.out.println(dropWhileList);
    }
}
