package nitin.streams.streamsAPIjava8.variousMethodsOfStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nitin C on 3/3/2016.
 *
 * The difference - map operation produces one output value for each input value, whereas the flatMap
 * operation produces an arbitrary number (zero or more) values for each input value.
 */
public class S9flatMap2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // for each even value, do nothing, for odd, take random as well and square
        List<Integer> l = list.stream()
                .flatMap(x -> {
                    if(x%2 == 0)
                        return Stream.empty();
                    else
                        return Stream.of(x, x*x);
                }).collect(Collectors.toList());
        System.out.println(l);
    }
}
