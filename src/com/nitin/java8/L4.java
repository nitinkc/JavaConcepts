package com.nitin.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nitin C on 2/27/2016.
 *
 * The double of the first even number in the list
 */
public class L4 {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        //Returns 0 if there is no integer exists
        System.out.println(
                values.stream()
                      .filter(e -> e > 3)
                      .filter(e -> e %2 == 0)
                      .map(e -> e * 2)
                      .findFirst()
                      .orElse(0)
        );
    }
}
