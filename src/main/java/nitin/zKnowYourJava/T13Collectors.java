package nitin.zKnowYourJava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class T13Collectors {
    public static void main(String[] args) {
        var numbers = Arrays.asList(10, 12, 23, 43, 65, 77, 14);

        var min = numbers.stream().collect(Collectors.minBy(Comparator.comparing(num -> num)));
        var max = numbers.stream().collect(Collectors.maxBy(Comparator.comparing(num -> num)));

        System.out.println(min + " " + max);

        var result =
                numbers.stream()
                        .collect(
                                Collectors.teeing(
                                        Collectors.maxBy(Comparator.comparing(num -> num)),
                                        Collectors.minBy(Comparator.comparing(num -> num)),
                                        List::of));

        System.out.println(result);

        // Get into a record
        var result2 =
                numbers.stream()
                        .collect(
                                Collectors.teeing(
                                        Collectors.maxBy(Comparator.comparing(num -> num)),
                                        Collectors.minBy(Comparator.comparing(num -> num)),
                                        (val1, val2) ->
                                                new MinMax(val1.orElse(0), val2.orElse(0))));

        System.out.println(result2);
    }
}

record MinMax(int min, int max) {}
