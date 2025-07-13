package nitin.streams.variousMethodsOfStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Created by Nitin C on 3/3/2016. */
public class S10distinct {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> collect =
                intList.stream()
                        .distinct() // What to do without bothering how to do
                        .collect(Collectors.toList());

        System.out.println(collect);
    }
}
