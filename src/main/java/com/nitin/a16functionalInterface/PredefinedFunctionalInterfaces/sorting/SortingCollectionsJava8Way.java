package com.nitin.a16functionalInterface.PredefinedFunctionalInterfaces.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingCollectionsJava8Way {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("I-5","I-15","I-25","I-35","I-45",
                "I-55","I-65","I-75","I-85","I-95","I-11","I-22","I-33");

        // Single Line Implementation
        //Collections.sort(list, ((String a, String b) -> Integer.parseInt(a.substring(2)) - Integer.parseInt(b.substring(2))));

        Comparator<String>  comparator = (String a, String b) -> Integer.parseInt(a.substring(2)) - Integer.parseInt(b.substring(2));
        // Sorting in Natural Order
        Collections.sort(list, comparator);
        // Sorting in reversed order
        Collections.sort(list, comparator.reversed());
        // Sorting the list as a list of String. I-45 < I-5 < I-55
        list.sort(Comparator.comparing(String::toString));
        // Sorting in
        //list.sort(Comparator.comparing(String::toString, (String a, String b) -> Integer.parseInt(a.substring(2)) - Integer.parseInt(b.substring(2))));
        list.sort(Comparator.comparing(String::toString,comparator.reversed()));

        list.forEach(System.out::println);

    }
}
