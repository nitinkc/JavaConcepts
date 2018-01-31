package com.nitin.a17functionalProgramming.streamsAPIjava8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Nitin C on 3/3/2016.
 * A stream in Java is a sequence of data
 * A Stream Pileline is the operation (STREAM OPERATIONS) that run on a stream to produce a result
 * Finite Streams have a limit
 * infinite Streams are like sunrise/sunset cycle
 *
 * SOURCE : Where the stream comes from
 * INTERMEDIATE OPERATIONS : Transforms the stream into another stream. STREAMS USE LAZY EVALUATION.
 * The intermediate operations do not run until the terminal operation runs.
 * TERMINAL OPERATION: Actually produces a result. Stream becomes invalid after terminal operation
 */
public class S1Introduction {
    public static void main(String[] args) {

        Stream<String> empty = Stream.empty();
        System.out.println(empty);

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //Creating a Stream from a list
        Stream<Integer> fromList = list.stream();
        //Creating a parallel Stream
        Stream<Integer> fromListParallel = list.parallelStream();

        Stream<Double> randoms = Stream.generate(Math::random);
        randoms.forEach(System.out::println);//Infinite Stream of Random numbers

    }
}
