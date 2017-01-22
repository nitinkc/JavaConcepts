package com.nitin.a17functionalProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Created by Nitin C on 3/3/2016.
 * Consumer and BiConsumer (Bi means 2 variables)
 * HAs a method accept
 * Use Consumer when you want to do something with the parameter
 * Ex: we use Consumer with forEach
 * list.forEach(System.out :: print);
 * OR
 * Consumer<String> c1 = System.out::println;
 * list.forEach(c1);
 * Consumer<String> c2 = x -> System.out.println(x);
 *
 *
 */
public class F3ImplementConsumer {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        BiConsumer<String,Integer> b1 = map::put;
        BiConsumer<String,Integer> b2 = (k,v) -> map.put(k,v);

        b1.accept("Chicken", 1);
        b2.accept("Mutton", 2);

        System.out.println(map);

    }
}
