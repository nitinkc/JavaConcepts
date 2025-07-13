package nitin.streams.variousMethodsOfStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nitin Chaurasia on 1/31/18 at 11:48 AM.
 *
 * <p>Applying Stream for group of values &amp; for arrays
 */
public class S7streamOf {
    public static void main(String[] args) {

        // For Group of values
        Stream<Integer> s = Stream.of(9, 99, 999, 9999, 99999);
        s.forEach(System.out::println);

        // For arrays
        Double[] d = {10.0, 10.1, 10.2, 10.3, 10.4};
        Stream<Double> s1 = Stream.of(d);
        s1.forEach(System.out::println);

        List<Double> collect = Stream.of(d).collect(Collectors.toList());

        List<Double> doubleList = Arrays.asList(d);
    }
}
