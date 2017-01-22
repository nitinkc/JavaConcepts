package com.nitin.a17functionalProgramming.javaStreamsAPI.commonTerminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class T1count {
    public static void main(String[] args) {
        Stream<String> stringList = Stream.of("Cat","Dog","Elephant","Frog","Goat");
        System.out.println(stringList.count());

        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //Creating a Stream froma  list
        Stream<Integer> fromList = intList.stream();
        System.out.println(fromList.count());
        //Exception : java.lang.IllegalStateException: stream has already been operated upon or closed
        System.out.println(fromList.findFirst());
    }
}
