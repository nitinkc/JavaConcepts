package com.nitin.a17Streams.streamsAPIjava8.variousMethodsOfStreams;

import java.util.stream.Stream;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class T6reduce {
    public static void main(String[] args) {
        m1();
        m2();
    }

    public static void m1(){
        Stream<String> arr = Stream.of("n","i","t","i","n");

        //String name = arr.reduce("",(s,c) -> s+c);//Terminal operation thus illegalStateOperation
        String name = arr.reduce("", String::concat);

        System.out.println(name);

    }

    public static void m2(){
        Stream<Integer> intStream = Stream.of(1,2,3,4,5,6,7);
        System.out.println(intStream.reduce(1, (a,b) -> a+b));
    }
}
