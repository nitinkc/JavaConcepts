package com.nitin.functionalProgramming;

import java.time.LocalDate;
import java.util.function.Supplier;

/**
 * Created by Nitin C on 3/3/2016.
 * To generate or Supply values without taking any input
 * has a method get.
 * The Supplier interface is used when you want to generate or supply values without taking any input.
 */
public class F2ImplementSupplier {
    public static void main(String[] args) {
        /* Creating date using factory */

        //Static method Reference
        Supplier<LocalDate> s1 = LocalDate::now;
        //Lambda Expression
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s1.get();

        System.out.println(d1 + " --- "+ d2);

        /* N1PathFileTest supplier is often used when constructing new object */

        //Constructor Reference
        Supplier<StringBuilder> myString = StringBuilder::new;
        Supplier<StringBuilder> myNewString = () -> new StringBuilder();


    }
}
