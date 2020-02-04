package com.nitin.zJava8Revisions.a1lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by nitin on Tuesday, February/04/2020 at 2:43 AM
 */
public class StreamsIntegerStrings {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Kealan Mccabe", "Ammarah Bloggs","Scarlette Cervantes", "Henry Davison", "Sophie Hough", "Umar Zimmerman");

        //Sort the Strings
        strList.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(x -> System.out.print(x+ " "));

        System.out.println();
        //Get the First names and Sort them in reverse natural order
        strList.stream()
                .map(str -> str.split(" ")[0])
                .sorted(Comparator.reverseOrder())
                .forEach(x -> System.out.print(x+ " "));

    }
}
