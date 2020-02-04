package com.nitin.a17Streams.streamsAPIjava8.variousMethodsOfStreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nitin Chaurasia on 1/31/18 at 12:40 AM.
 */
public class S3sorted {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Pawan");
        list.add("Chiranjeevi");
        list.add("RaviTeja");
        list.add("Venkatesh");
        list.add("Nagarjuna");
        System.out.println(list);

        // Sort elements of the Stream, using DNSO
        List<String> l = list.stream().sorted().collect(Collectors.toList());
        System.out.println(l);

        // Reverse Sorted, customised sorted order
        List<String> l2 = list.stream().sorted((str1,str2) -> str2.compareTo(str1)).collect(Collectors.toList());
//        List<String> l3 = list.stream().sorted(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                o2.compareTo(o1);
//            }
//        }).collect(Collectors.toList());
        System.out.println(l2);


        list.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing((str1, str2) -> str2.compareTo(str1)))
                .forEach(System.out::println);

    }
}
