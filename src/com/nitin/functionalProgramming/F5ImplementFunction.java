package com.nitin.functionalProgramming;

import java.util.function.Function;

/**
 * Created by Nitin C on 3/3/2016.
 * N1PathFileTest function is responsible for turning one parameter into a value of a potentially different type and returning it.
 * has a method apply
 */
public class F5ImplementFunction {
    public static void main(String[] args) {

        //Takes String as input and and return an Integer as output
        Function<String, Integer> f1 = String::length;
        Function<String, String> f2 = x -> x.toUpperCase();

        //Implement a function to reverse a String

        System.out.println(f1.apply("Nitin"));
        System.out.println(f2.apply("chaurasia"));

    }
}
