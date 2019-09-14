package com.nitin.a16functionalInterface.PredefinedFunctionalInterfaces;

import java.time.LocalDate;
import java.util.function.Supplier;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 10:13 PM.
 *  Created by Nitin C on 3/3/2016.
 * To generate or Supply values without taking any input
 * has a method get.
 * The Supplier interface is used when you want to generate or supply values without taking any input.
 */
public class PDF5Supplier {

    public static void main(String[] args) {

        Supplier<String> s = () -> {
            String[] str = {"Nitin", "Kirti", "Chaurasia", "Love"};
            int x = (int)(Math.random()*3+1);
            return str[x];
        };

        System.out.println(s.get());




        /* Creating date using factory */

        //Static method Reference
        Supplier<LocalDate> s1 = LocalDate::now;
        //Lambda Expression
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s1.get();

        System.out.println(d1 + " --- "+ d2);

        /* A supplier is often used when constructing new object */

        //Constructor Reference
        Supplier<StringBuilder> myString = StringBuilder::new;
        Supplier<StringBuilder> myNewString = () -> new StringBuilder();

    }

}
