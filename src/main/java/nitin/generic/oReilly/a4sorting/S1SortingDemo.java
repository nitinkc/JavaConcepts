package nitin.generic.oReilly.a4sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.toList;

public class S1SortingDemo {
    private List<String> sampleStrings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    // Default sort from Java 7-
    public List<String> alphaSort() {
        Collections.sort(sampleStrings);
        return sampleStrings;
    }

    // Java 7- using Comparator with anonymous inner class
    public List<String> lengthReverseSortWithComparator() {
        Collections.sort(sampleStrings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();// Reverse Sorting, due to s2-s1
            }
        });
        return sampleStrings;
    }

    // Default sort from Java 8+
    public List<String> alphaSortUsingStreams() {
        return sampleStrings.stream()
                .sorted()
                .collect(toList());
    }

    // Using a lambda as a Comparator with a lambda
    public List<String> lengthSortWithLambda() {
        Collections.sort(sampleStrings,
                (s1, s2) -> s1.length() - s2.length());
        return sampleStrings;
    }

    // Sort by length with sorted
    public List<String> lengthSortUsingSorted() {
        return sampleStrings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(toList());
    }

    // Length sort with comparingInt
    public List<String> lengthSortUsingComparator() {
        return sampleStrings.stream()
                .sorted(comparing(String::length))
                .collect(toList());
    }

    // Sort by length then alpha using sorted
    public List<String> lengthSortThenAlphaSortUsingSorted() {
        return sampleStrings.stream()
                .sorted(comparingInt(String::length)
                        .thenComparing(naturalOrder()))
                .collect(toList());
    }

    // Sort by length then reverse alpha using sorted
    public List<String> lengthSortThenReverseAlphaUsingSorted() {
        return sampleStrings.stream()
                .sorted(comparing(String::length)
                        .thenComparing(reverseOrder()))
                .collect(toList());
    }
}
