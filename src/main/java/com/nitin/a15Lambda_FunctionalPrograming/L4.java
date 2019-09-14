package com.nitin.a15Lambda_FunctionalPrograming;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nitin C on 2/27/2016.
 *
 * The double of the first even number > 3 and in the a_list
 */
public class L4 {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        //Imparative Code
        int result = 0;
        for (int e: values) {
            if (e > 3 && e % 2 == 0) {// testing for 1,2,3,4 and the break: 8 times if test
                result = e * 2;
                break;
            }
        }
        System.out.println(result);

        //Returns 0 if there is no integer exists
        //This code reveals the details
        System.out.println(
                values.stream()
                      .filter(e -> e > 3)
                      .filter(e -> e %2 == 0)
                      .map(e -> e * 2)
                      .findFirst()
                      .orElse(0)
        );

        //testing for the number of time it is working
        //Demonstrating the LAZY
        System.out.println(
                values.stream()
                        .filter(L4::isGT3)//another way of calling a method from lambda
                        .filter(L4::isEven)//functions like filter and map are called intermediate functions.  They are LAzy
                        .map(L4::doubleIt)
                        .findFirst() //terminal Function: triggers the computations, the code ACTUALLY STARTS WORKING
                        // FROM THIS POINT ON due to LAziness. The computations are only enough to get the work done
                        .orElse(0)
        );

        //Demonstrating the LAZY way by removing the terminal function. the intermediatry doent even do anything
        // this is LAZY evaluation. in Java its called efficient!!
        values.stream()
            .filter(L4::isGT3)//another way of calling a method from lambda
            .filter(L4::isEven)//functions like filter and map are called intermediate functions.  They are LAzy
            .map(L4::doubleIt);

        System.out.println("here");
    }

    public static boolean isEven(int number){
        System.out.println("is Even For " + number);
        return number % 2 == 0;
    }
    public static boolean isGT3(int number){
        System.out.println("isGT3 for " + number);
        return number > 3;
    }
    public static int doubleIt(int number){
        System.out.println("doubleIt for " + number);
        return number * 2;
    }
}
