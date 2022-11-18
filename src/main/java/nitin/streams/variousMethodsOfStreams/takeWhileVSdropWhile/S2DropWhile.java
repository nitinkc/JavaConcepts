package com.nitin.learning.streams.takeWhileVSdropWhile;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nitin on Sunday, January/26/2020 at 8:21 PM
 * TakeWhile runs until the first false/negative condition is met
 * DropWhile runs from the first negative condition is met.
 */
public class S2DropWhile {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", null, "two", "three", "four", null,"circuit breaker", "five",
                "six", "seven","","",null,null);
        //list = Arrays.asList(null,null,null,null);
        //list = Arrays.asList("","","","");

        takeWhileUntilLen7Comes(list);

        //DropWhile runs from the first negative condition is met.
        dropStringsuntilLen7Comes(list);

        pickFirstNonNullSortedString(list);
    }

    private static void dropStringsuntilLen7Comes(List<String> list) {
        List<String> dropWhileList = list
                .stream()
                //.filter(str -> null != str)
                .filter(Objects::nonNull)
                .dropWhile(str -> str.length() < 7)
                .collect(Collectors.toList());
        System.out.println(dropWhileList);
    }

    private static void takeWhileUntilLen7Comes(List<String> list) {
        List<String> takeWhileList = list
                .stream()
                //.filter(str -> null != str)
                .filter(Objects::nonNull)
                .takeWhile(str -> str.length() < 7)//take the strings until a string of lenght 7 comes
                .collect(Collectors.toList());
        System.out.println(takeWhileList);
    }

    private static void pickFirstNonNullSortedString(List<String> list) {
        List<String> singleElementList =  Collections.singletonList(Optional.of(list
                .stream()
                .filter(singleStr -> null != singleStr)//Removing nulls
                .sorted(Comparator.naturalOrder())
                .dropWhile(str -> str.isBlank())//Removing Empty Strings
                //.peek(x-> System.out.println(x))
                .findFirst()).get().orElse(StringUtils.EMPTY));

        System.out.println(singleElementList);
    }
}
