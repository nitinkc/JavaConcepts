package com.nitin.a9generics.oReilly.bWildcards;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class B1Unbounded {
    public static void main(String[] args) {
        List<?> list = Arrays.asList((22/7),"test", LocalDate.now(),'c');

        //size method is indepoendent of underlying data type
        System.out.println(list.size());

        //Invoking Lambda on the list
        list.forEach((Object o) -> System.out.println(o));

        // Cannot be written
        //list.add("another String");//incompatible types: java.lang.String cannot be converted to capture#1 of ?

        System.out.println(list.containsAll(Arrays.asList("test", (22/7))));
    }
}
