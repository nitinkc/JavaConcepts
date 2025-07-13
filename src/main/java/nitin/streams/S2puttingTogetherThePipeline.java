package nitin.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/** Created by Nitin C on 3/3/2016. */
public class S2puttingTogetherThePipeline {
    public static void main(String[] args) {
        m1();

        m2();
    }

    private static void m1() {
        List<Integer> list = Arrays.asList(1, 23, 45, 67, 8, 9, 123, 124, 564, 123);

        Predicate<Integer> even = (n -> n % 2 != 0);
        Predicate<Integer> gtThan = (n -> n > 30);
        Predicate<Integer> ltThan = (n -> n < 500);

        // Predicate if number is even and greater than 30 and less than 500
        Predicate<Integer> doublePredicate = even.and(gtThan).and(ltThan);

        // The same functionality as below declarative can be implemented as imparative
        // with multi-line code using if and for loop
        list.stream()
                .filter(doublePredicate)
                .sorted()
                // .limit(2)
                .forEach(System.out::println);
    }

    private static void m2() {
        Stream<String> list = Stream.of("Abacus", "Babylon", "Cairo", "Damascus", "Estury");

        list.filter(s -> s.length() > 5)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
