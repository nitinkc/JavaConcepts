package com.nitin.Optionals;

import java.util.Optional;

/**
 * Created by nichaurasia on Monday, June/01/2020 at 10:52 PM
 */

public class O3OperationsOnOptional {

    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.of("Testing");
        Optional<String> emptyStringOptional = Optional.empty();

        //map - ACCEPTS A FUNCTION, TAKES SOME ARGUMENT AND PERFORM ACTION ON IT
        Optional<String> map = stringOptional.map(x -> x.toUpperCase());
        String emptyMap = emptyStringOptional
                .map(x -> x.toUpperCase())
                .orElse("Empty Map");

        System.out.println(map.get());
        System.out.println(emptyMap);



        //filter
        //flatMap

    }
}
