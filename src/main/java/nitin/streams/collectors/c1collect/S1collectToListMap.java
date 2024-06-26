package nitin.streams.collectors.c1collect;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Nitin Chaurasia on 1/31/18 at 12:05 AM.
 */
public class S1collectToListMap {
    public static void main(String[] args) {
        List<String> list = List.of("Pawan", "Chiranjeevi", "RaviTeja", "Venkatesh", "Nagarjuna");
        System.out.println(list);

        //Create a now list with actors having names longer than 9 characters
        List<String> l = list.stream().filter(str -> str.length() >= 9)
                .collect(Collectors.toList());
        //System.out.println(l);

        //Defining boolean predicate to test if the string is shorter than 9 characters
        Predicate<String> strShort = (str -> str.length() < 9);
        //Create another list of short characters
        List<String> l1 = list.stream()
                .filter(strShort)
                .collect(Collectors.toList());
        //System.out.println(l1);

        //Change all the names to uppercase
        // Using a function as a return value is expected
        Function<String, String> upperCase = (str) -> str.toUpperCase();
        List<String> l2 = list.stream()
                .map(upperCase)
                .collect(Collectors.toList());
        //System.out.println(l2);

        Map<String, Integer> map = list.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));

        map.forEach((key, value) -> System.out.println(key + value));
        //System.out.println(map);

    }
}
