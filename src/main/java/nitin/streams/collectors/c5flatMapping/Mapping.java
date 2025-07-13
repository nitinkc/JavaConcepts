package nitin.streams.collectors.c5flatMapping;

import java.util.List;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 1, 3, 3, 4, 5, 6, 7, 8, 6, 5, 4, 3, 2, 1);

        List<Integer> doubleNumberList =
                list.stream()
                        .distinct() // Finds unique elements
                        .collect(Collectors.mapping(number -> number * 2, Collectors.toList()));
        System.out.println(doubleNumberList); // [2, 4, 6, 8, 10, 12, 14, 16]
    }
}
