package com.nitin.a17functionalProgramming.streamsAPIjava8.variousMethodsOfStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Nitin Chaurasia on 1/31/18 at 12:33 AM.
 * <p>
 * Count method Present in Stream Class
 * public long count(); returns a long value
 */
public class S2count {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Pawan");
        list.add("Chiranjeevi");
        list.add("RaviTeja");
        list.add("Venkatesh");
        list.add("Nagarjuna");
        System.out.println(list);

        Predicate<String> strLong = str -> str.length() >= 9;
        // Count the number of strings greater than 9 characters
        long count = list.stream().filter(strLong).count();

        System.out.println(count);

        Stream<String> stringList = Stream.of("Cat","Dog","Elephant","Frog","Goat");
        System.out.println(stringList.count());

        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //Creating a Stream from list
        Stream<Integer> fromList = intList.stream();
        System.out.println(fromList.count());
        //Exception : java.lang.IllegalStateException: stream has already been operated upon or closed
        System.out.println(fromList.findFirst());
    }
}
