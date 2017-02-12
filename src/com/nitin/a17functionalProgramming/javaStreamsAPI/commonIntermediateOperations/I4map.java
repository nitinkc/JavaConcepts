package com.nitin.a17functionalProgramming.javaStreamsAPI.commonIntermediateOperations;

import java.util.stream.Stream;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class I4map {
    public static void main(String[] args) {
        Stream<String> list = Stream.of("nitin","nidhi","niti");

        // Lambda Expression
        list.map(a -> a.length()).forEach(b -> System.out.println(b));

        //The same is written in the
        //a_list.map(String::length).forEach(System.out::print);
    }
}
