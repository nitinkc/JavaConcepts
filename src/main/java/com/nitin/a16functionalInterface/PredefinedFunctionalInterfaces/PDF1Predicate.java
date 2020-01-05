package com.nitin.a16functionalInterface.PredefinedFunctionalInterfaces;

import com.sun.javadoc.ProgramElementDoc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 5:41 PM.
 * A predicate is a function with a single argument and returns boolean value.
 * Predicate interface is present in Java.util.function package

 It’s a functional interface and it contains only one method i.e., test() 
 */
public class PDF1Predicate {
    public static void main(String[] args) {

        // Predicate to test if an int is Greater than 10
        //Predicate<Integer> p = i -> {return i>10;};
        Predicate<Integer> p1 = i ->  i>10;
        System.out.println(p1.test(10));
        System.out.println(p1.test(6));//false


        //Predicate to check length of the String is less than 5
        Predicate<String> p2 = str -> (str.length() < 6);
        System.out.println(p2.test("Nitin"));
        System.out.println(p2.test("Chaurasia"));

        //Predicate to test of a Collection is Empty
        Predicate<Collection> p3 = c -> c.isEmpty();
        ArrayList l1 = new ArrayList(); l1.add(23);
        ArrayList l2 = new ArrayList();
        System.out.println(p3.test(l1));
        System.out.println(p3.test(l2));


        List<String> list = Arrays.asList("first","second","third","testString");

        // Static reference as there are no parameter
        Predicate<String> p4 = String::isEmpty;
        Predicate<String> p5 = (s -> s.contains("testString"));

        System.out.println(p4.test(""));//true
        System.out.println(p5.test("TestString"));//false

        //How to use this predicate in the List??
        Predicate<String> testIsEmpty = String::isEmpty;

    }
}
