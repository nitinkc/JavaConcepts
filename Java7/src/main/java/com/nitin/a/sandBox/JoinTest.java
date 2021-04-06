package com.nitin.a.sandBox;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JoinTest {
    public static void main(String[] args) {
        List<String> strings = List.of("asasdad","adadad","ewrewrewr");
        String message = String.join(",", strings);
        //message returned is: "Java is cool"

       // System.out.println(message);

        String test = strings.stream().collect(Collectors.joining(","));
        System.out.println(test);
    }
}
