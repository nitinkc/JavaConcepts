package com.nitin.a17Streams;

import java.util.stream.DoubleStream;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class P1DoubleStream {
    public static void main(String[] args) {
        DoubleStream oneValue = DoubleStream.of(3.14, 4.34, 6.50);

        System.out.println(oneValue.count());
    }
}
