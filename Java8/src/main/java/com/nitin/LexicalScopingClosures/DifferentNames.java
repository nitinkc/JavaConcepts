package com.nitin.LexicalScopingClosures;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Function;

public class DifferentNames {

    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

    public static final List<String> namesList = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(final String[] args) {

        {
            final Predicate<String> startsWithN = name -> name.startsWith("N");
            final Predicate<String> startsWithB = name -> name.startsWith("B");

            final long countFriendsStartN =
                    namesList.stream()
                            .filter(startsWithN).count();
            final long countFriendsStartB =
                    namesList.stream()
                            .filter(startsWithB).count();


            System.out.println("Block 1");
            System.out.println(countFriendsStartN);
            System.out.println(countFriendsStartB);
        }

        {
            final long countFriendsStartN =
                    namesList.stream()
                            .filter(checkIfStartsWith("N")).count();
            final long countFriendsStartB =
                    namesList.stream()
                            .filter(checkIfStartsWith("B")).count();


            System.out.println("Block 2");
            System.out.println(countFriendsStartN);
            System.out.println(countFriendsStartB);
        }

        {
            // Function, taking in a String and returning a Predicate, as expected by a filter
            final Function<String, Predicate<String>> startsWithLetter =
            (String letter) -> {
            Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
            return checkStarts;
        };

            final long countFriendsStartN =
                    namesList.stream()
                            .filter(startsWithLetter.apply("N")).count();

            final long countFriendsStartB =
                    namesList.stream()
                            .filter(startsWithLetter.apply("B")).count();

            System.out.println("Block 3");
            System.out.println(countFriendsStartN);
            System.out.println(countFriendsStartB);
        }

        {
            final Function<String, Predicate<String>> startsWithLetter =
            (String letter) -> (String name) -> name.startsWith(letter);

            final long countFriendsStartN =
                    namesList.stream()
                            .filter(startsWithLetter.apply("N")).count();

            final long countFriendsStartB =
                    namesList.stream()
                            .filter(startsWithLetter.apply("B")).count();

            System.out.println("Block 4");
            System.out.println(countFriendsStartN);
            System.out.println(countFriendsStartB);
        }

        {
            final Function<String, Predicate<String>> startsWithLetter =
            letter -> name -> name.startsWith(letter);

            final long countFriendsStartN =
                    namesList.stream()
                            .filter(startsWithLetter.apply("N")).count();
            final long countFriendsStartB =
                    namesList.stream()
                            .filter(startsWithLetter.apply("B")).count();


            System.out.println("Block 5");
            System.out.println(countFriendsStartN);
            System.out.println(countFriendsStartB);
        }
    }
}