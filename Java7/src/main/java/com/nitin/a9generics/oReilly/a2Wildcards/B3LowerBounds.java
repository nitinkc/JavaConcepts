package com.nitin.a9generics.oReilly.a2Wildcards;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B3LowerBounds {

    public static void main(String[] args) {
        List<String> strings = Stream.of("a", "few", "strings")
                .collect(Collectors.toList());

        strings.forEach((String s) -> System.out.printf("%s in all caps is %s%n", s, s.toUpperCase()));
        System.out.println("****************************");
        strings.forEach((Object o) -> System.out.printf("%s has hashCode %d%n", o, o.hashCode()));
        System.out.println("****************************");

        // Stream<T> peek(Consumer<? super T> action);
        // Using Methods of Integer and Above
        List<Integer> integers = Stream.of(3, 1, 4, 1, 5, 998)
                .peek(i -> System.out.println(i + " as a binary string is " + Integer.toBinaryString(i)))
                .peek((Number n) -> System.out.println("The double value of " + n + " is " + n.doubleValue()))
                .peek((Object o) -> System.out.println("The default hashcode of " + o + " is " + o.hashCode()))
                .collect(Collectors.toList());
        System.out.println("****************************");
        System.out.println(integers);

        /* @apiNote This method exists mainly to support debugging, where you want
         * to see the elements as they flow past a certain point in a pipeline:
         * <pre>{@code
         *     Stream.of("one", "two", "three", "four")
                    *         .filter(e -> e.length() > 3)
                    *         .peek(e -> System.out.println("Filtered value: " + e))
                    *         .map(String::toUpperCase)
                    *         .peek(e -> System.out.println("Mapped value: " + e))
                    *         .collect(Collectors.toList());
         */
    }
}
