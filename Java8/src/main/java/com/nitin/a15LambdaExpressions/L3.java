package com.nitin.a15LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Nitin C on 2/27/2016.
 *
 * Strategy pattern. writing a function to be called from Lambda
 */
public class L3 {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        //Print sum of all numbers
        System.out.println(totalValues(values, e -> true));

        //Print sum of all all Even numbers
        System.out.println(totalValues(values, e -> e%2 == 0));

        //Print sum of all odd numbers
        System.out.println(totalValues(values, e -> e%2 != 0));
    }

    public static int totalValues(List<Integer> numbers, Predicate<Integer> selector){
            return numbers.stream()
                       .filter(selector)
                       .reduce(0, (c,e) -> c + e);
        // reduce (0, (c,e) ...) needs a seed value to begin with
        // thus c = 0 and subsquiently c becomes the result  of the previous call
    }
}
