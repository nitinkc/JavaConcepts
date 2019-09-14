package com.nitin.a17functionalProgramming.streamsAPIjava8.variousMethodsOfStreams;

import java.util.stream.Stream;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class S8map {
    public static void main(String[] args) {
        Stream<String> list = Stream.of("Nitin","Nidhi","Niti");

        // Lambda Expression
        list.map(a -> a.length()).forEach(b -> System.out.println(b));

        //The same is written in method reference
        //a_list.map(String::length).forEach(System.out::print);
    }
}
