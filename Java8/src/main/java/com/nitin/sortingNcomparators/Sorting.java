package com.nitin.sortingNcomparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by nichaurasia on Thursday, February/13/2020 at 11:50 AM
 */

public class Sorting {
    public static void main(String[] args) {
        final List<Person> list = Arrays.asList(
                new Person("John",20),
                new Person("Wayne", 20),
                new Person("Dow", 30),
                new Person("Jane", 35)
        );

       /* list.stream()
                .sorted((x,y) -> x.ageDifference(y))
                .forEach(System.out::println);*/

        //Same way of writing above, without using utility method
        list.stream()
                .sorted(Comparator
                        .comparing(Person::getAge)
                        .thenComparing(Person::getName)
                )
                .forEach(System.out::println);
    }
}
