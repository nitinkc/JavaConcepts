package nitin.streams.collectors.c1collect;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

/**
 * Created by Nitin Chaurasia on 1/31/18 at 12:05 AM.
 */
public class S1collect_toList_toMap {
    public static void main(String[] args) {
        List<String> list = List.of("Pawan", "Chiranjeevi", "RaviTeja", "Venkatesh", "Nagarjuna");
        System.out.println(list);

        //Create a now list with actors having names longer than 9 characters
        List<String> l = list.stream()
                .filter(str -> str.length() >= 9)
                .toList();
        //System.out.println(l);

        //Defining boolean predicate to test if the string is shorter than 9 characters
        Predicate<String> strShort = (str -> str.length() < 9);
        //Create another list of short characters
        List<String> l1 = list.stream()
                .filter(strShort)
                .toList();
        //System.out.println(l1);

        /* MAP */
        //Change all the names to uppercase
        // Using a function as a return value is expected

        Map<String, Integer> map = list.stream()
                .collect(Collectors.toMap(identity(), String::length));
        System.out.println(map);

        Map<Integer, List<String>> collect = list.stream()
                .collect(groupingBy(str -> str.length(), mapping(str->str.toUpperCase(),toList())));
        System.out.println(collect);
    }
}
