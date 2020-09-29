package com.nitin.zOReiley2020SimonRoberts;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author Created by nichaurasia
 * @create on Sunday, September/27/2020 at 3:30 PM
 */

public class TestJava8 {
    public static void main(String[] args) {

        //Creating a stream of Integer

        //By arrayList

        //By Stream.of
        List<Integer> list = Stream
                .of(2,3,4,5,6,7,8,9,10,20,30)
                .collect(Collectors.toList());

        // Find all the Odd numbers
        list.stream()
                //.limit(4)
                .filter(x -> x%2 !=0)
                .peek(x -> System.out.println("Filtered Odd : " + x))
                //.filter(y -> y >= 5)
                .mapToInt(x -> x)
                .average()
                .ifPresent(System.out::println);
                //.map(x -> x+0.1)
                //.flatMap(x1 -> Stream.of(x1*1, x1*2, x1*3) )
               // .limit(4)
                //.collect(Collectors.toList());
                //.forEach(System.out::println);

       // System.out.println(result);
    }
}
