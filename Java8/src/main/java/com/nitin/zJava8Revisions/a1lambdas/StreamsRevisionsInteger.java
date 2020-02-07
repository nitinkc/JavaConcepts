package com.nitin.zJava8Revisions.a1lambdas;

import com.nitin.apacheCommons.ApacheCommons;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by nitin on Tuesday, February/04/2020 at 1:36 AM
 */
public class StreamsRevisionsInteger {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(90, 88, 32, 74, 98, 82, 12, 28, 77, 94, 13, 96, 25, 17, 65);

        System.out.println("Find all the Odd numbers and print it");
        //Find all the Odd numbers and print it
        intList.stream()
                .filter(x -> x%2 !=0)
                .forEach(x -> System.out.print(x+ " "));

        System.out.println("\nFind all even and arrange in Sorted Order using Anonymous comparator");
        //Find all even and arrange in Sorted Order
        intList.stream()
                .filter(x -> x%2 == 0)
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                })
                .forEach(x -> System.out.print(x+ " "));

        System.out.println("\nFind all Odd and arrange in Sorted Order ");
        //Find all Odd and arrange in Sorted Order
        intList.stream()
                .filter(x -> x%2 != 0)
                //.sorted(Comparator.naturalOrder())
                .sorted()
                .forEach(x -> System.out.print(x+ " "));

        System.out.println("\nFind all Odd and arrange in Reverse Sorted Order ");
        //Find all Odd and arrange in Reverse Sorted Order
        intList.stream()
                .filter(x -> x%2 != 0)
                .sorted(Comparator.reverseOrder())
                .forEach(x -> System.out.print(x+ " "));

        System.out.println("\nFind all Odd greater than 20, and add all of them ");
        //Find all Odd greater than 20, and add all of them
        System.out.println(
                intList.stream()
                .filter(x -> x%2 != 0)
                .filter(y -> y > 20)
                .reduce((x,y) -> x+y)
                .get()
        );

        //Find all Primes
        intList.stream()
                .filter(x -> Primes)

    }
}
