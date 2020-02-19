package com.nitin.higherOrderFunctions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by nitin on Tuesday, February/18/2020 at 9:44 PM
 */
public class Example1 {
    public static final List<String> namesList = Arrays.asList("Adrian", "Briana", "Chetan", "Neil", "Nitin", "Mukesh");

    public static void main(String[] args) {
        final Function<String, Predicate<String>> startsWithLetterFunction =
                (String letter) -> {
                    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                    return checkStarts;
                };

        System.out.println("Block 3");
        System.out.println(namesList.stream()
                .filter(startsWithLetterFunction
                        .apply("N"))
                .count());

        System.out.println(namesList.stream()
                .filter(startsWithLetterFunction
                        .apply("B"))
                .count());
    }
}