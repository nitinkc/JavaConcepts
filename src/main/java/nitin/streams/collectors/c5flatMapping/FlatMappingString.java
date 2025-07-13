package nitin.streams.collectors.c5flatMapping;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMappingString {
    public static void main(String[] args) {
        List<String> list =
                List.of("one", "two wings", "three tyres", "four turbo combustion engine");
        // Fnd a list of each word separated without space
        List<String> collect =
                list.stream()
                        .collect(
                                Collectors.flatMapping(str -> Stream.of(str.split(" ")), toList()));

        System.out.println(
                collect); // [one, two, wings, three, tyres, four, turbo, combustion, engine]
    }
}
