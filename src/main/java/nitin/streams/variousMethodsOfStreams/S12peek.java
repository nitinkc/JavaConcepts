package nitin.streams.variousMethodsOfStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class S12peek {
    public static void main(String[] args) {
        //Used extensively for debugging
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> integerList = intList.stream()
                .map(num -> num*num)
                .peek(x -> System.out.print(x + "\t"))
                .limit(5)
                .peek(x -> System.out.print(x + "\t"))
                .collect(Collectors.toList());

        // Lazy Evaluation in Streams. Streams will be calculated when a terminal operator
        // is encountered.
    }
}
