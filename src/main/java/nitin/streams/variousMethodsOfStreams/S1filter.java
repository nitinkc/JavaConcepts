package nitin.streams.variousMethodsOfStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class S1filter {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4,6,8,9,7,5,3,2);

        // Filter takes in a Predicate functional interface
        List<Integer> collect = list.stream()
                .filter(num -> num % 2 != 0)
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
