package com.nitin.a17functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Nitin C on 3/3/2016.
 *
 * Predicate is used when Filtering or MAtching
 * Has a method test
 * */
public class F4ImplementPredicate {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("first","second","third","testString");

        // Static reference as there are no parameter
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = (s -> s.contains("testString"));

        System.out.println(p1.test(""));//true
        System.out.println(p2.test("TestString"));//false

        //How to use this predicate in the List??
        Predicate<String> testIsEmpty = String::isEmpty;

        Predicate<String> egg = (s -> s.contains("egg"));
        Predicate<String> brownEgg = (s -> s.contains("brown"));
        //Predicate if both egg and brownEgg exists
        Predicate<String> doublePredicate = egg.and(brownEgg);
        Predicate<String> doublePredicateNegate = egg.and(brownEgg.negate());
    }
}