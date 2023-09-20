package nitin.streams.variousMethodsOfStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class S11limitSkip {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> integerList = intList.stream()
                .limit(5)
                .map(num -> num*num)
                .collect(Collectors.toList());

        System.out.println(integerList);

        List<Integer> integerList2 = intList.stream()
                .skip(5)
                .map(num -> num*num)
                .collect(Collectors.toList());
        System.out.println(integerList2);


    }
}
