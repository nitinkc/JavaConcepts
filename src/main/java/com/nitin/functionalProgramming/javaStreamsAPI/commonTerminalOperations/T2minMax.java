package com.nitin.functionalProgramming.javaStreamsAPI.commonTerminalOperations;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class T2minMax {
    public static void main(String[] args) {
        Stream<String> stringList = Stream.of("Cat","Dog","Elephant","Frog","Goat");
        //min needs a comparator
        Optional<String> min = stringList.min((s1,s2) -> s1.compareToIgnoreCase(s2));
        min.ifPresent(System.out::println);
        //get also return the same thing
        System.out.println(min.get());
    }

}
