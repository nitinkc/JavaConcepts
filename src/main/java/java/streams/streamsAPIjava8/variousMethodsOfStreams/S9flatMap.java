package java.streams.streamsAPIjava8.variousMethodsOfStreams;

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
public class S9flatMap {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Pawan");
        list.add("Chiranjeevi");
        list.add("RaviTeja");
        list.add("Venkatesh");
        list.add("Nagarjuna");
        System.out.println(list);

        // for each values, generate uppercase and find length
        List<String> l = list.stream()
                .flatMap(x -> Stream.of(x.toUpperCase(),String.valueOf(x.length()), x.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println(l);

        l.stream()
                //.map(str -> str.toLowerCase())
                .flatMap(x -> Stream.of(x.toLowerCase(),x.toUpperCase(),x.length()))
                .forEach(x -> System.out.print(x+", "));
    }
}
