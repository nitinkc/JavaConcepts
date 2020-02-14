package com.nitin.joining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nitin on Thursday, February/13/2020 at 9:50 PM
 */
public class JoiningElements {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("John","Doe","Jane","Dow","Yong","Lee");

        // No more Off-By-One Error
        System.out.println(String.join(", ",list));

        System.out.println(
                list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" | "))
        );
    }
}
