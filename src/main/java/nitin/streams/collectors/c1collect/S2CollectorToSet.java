package nitin.streams.collectors.c1collect;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class S2CollectorToSet {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 1, 3, 3, 4, 5, 6, 7, 8, 6, 5, 4, 3, 2, 1);

        Set<Integer> intSet = intList
                .stream()
                //do Whatever you like
                .collect(Collectors.toSet());

        System.out.println(intList);
        System.out.println(intSet);
    }
}
