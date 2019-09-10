package com.nitin.a15Lambda_FunctionalPrograming.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 4:25 AM.
 * Lambda Expression is just an anonymous (nameless) function.
 */
public class L1Lambda {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(doubling(list));
        adding(5, 6);

        //Testing if else in Lambda
        list.replaceAll( (x) -> { if (x%2 == 0)
            return x;
        else
            return x*x;});

        System.out.println(list);
    }

    // When only one parameter is available, small parenthesis is optional
    private static List<Integer> doubling(List<Integer> nums){

        //small parenthesis around x is optional
        nums.replaceAll( (x) -> {return x*2;});//First Doubling

        // simplified
        nums.replaceAll(x -> x%2 == 0 ? x : x*x);//Second Doubling
        return nums;
    }

    // When 2 parameters are there, it has to be separated by ,
    // Specifying the type of parameter can also be omitted - TYPE INFERENCE
    private static void adding(int a, int b) {

        Ball n = () -> System.out.println(a + b);
        n.hit();

    }
}

interface Ball
{
    void hit();
}
