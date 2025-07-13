package nitin.streams.variousMethodsOfStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Created by nitin on Sunday, January/26/2020 at 10:42 PM */
public class S4OfNullable {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Andy", "B", null, "D", null, "F");

        // First way of avoiding NullPointerException
        List<String> collect =
                list.stream()
                        .filter(object -> object != null)
                        .filter(Objects::nonNull)
                        .map(str -> str.toLowerCase())
                        .collect(Collectors.toList());
        System.out.println(collect);

        // Use of FlatMap with ofNullable to avoid null pointer exception
        List<String> strings =
                list.stream()
                        .flatMap(object -> Stream.ofNullable(object))
                        .map(str -> str.toLowerCase())
                        .collect(Collectors.toList());

        System.out.println(strings);
    }
}
