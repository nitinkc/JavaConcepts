package com.nitin.a15Lambda_java8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nitin C on 2/27/2016.
 *
 * The biggest change in the Java 8 is in the minds of the programmers. N1PathFileTest lot of fun to be learning a better way of programming
 */
public class L1BasicWithListIteration {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9);

        // Complex, initial (boundry less than or less than equal to)
        // Self inflicted wound pattern
       /* for(int i = 0; i < values.size(); i++){
            System.out.println(values.get(i));
        }*/

        // Fewer moving parts
       /* for (int element: values) {
            System.out.println(element);
        }*/

        /* Those were External Iterator (Manage outside)*/

        //Internal iterator, oput on autopilio, juts tel waht to do
        // NO how the iteratoonis done, and just tell waht to do

        //method forEach is called on the object
        // Anonymous inner class
        //This gives polymorphism
        //forEach method is now on a10collections
       /* values.forEach(new Consumer<Integer>() {//Consumer is a new interface in java 8
            @Override
            public void accept(Integer value) {// mehtod of consumer, which accets the array
                System.out.println(value);

            }
        });*///FUNDAMENTAL DIFFERENCE  SYMENTACALLY
        //
        // Polymorphism says : dont worry how things are done, worry about what you wanna do
        // and decide the imple at one time. Whether its sequential or concurrent or lazy, i dont want now, it want to po
        //stpone the decision tio a later toime

        // Ceremony is the things that you HAVE do before you do before you do waht you REALLY want to do
        values.forEach((Integer element) -> System.out.print(element) );
        System.out.println();
        /* forEach says i am accepting a FUNCTION
        * a Function has 4 things - name, return type, parameter a_list and Body
        * Most Imp: is Body of the function
        * Body of the function -> System.out.println(element)
        * Parameter List --> (Integer element)
        * */

        // N1PathFileTest collection of integer is known to integer
        // Java figures out BASED ONTHE CONTEXCT.
        // Dont have to write the obvious
        values.forEach((element) -> System.out.print(element));
        System.out.println();
        // Removing the brackets
        values.forEach(element -> System.out.print(element));
        System.out.println();
        //
        values.forEach(System.out::print);
        System.out.println();
        // ForEach receives a Consumer functional parameter
        // Functional Interface : can be automatically be elevated to lambda expression
        //In other words, you can Only use lambdas for functional interfaces
        // N1PathFileTest functional interface is a SAM (Single abstract Method) interface. it can only have one abstract method
        // that method has signture with parameter coming in.
        //Functional interface assign a contract!!

        //forEach received Consumer F interface


        /*DOUBLE THE VALUE AND TOTAL*/

        //imparative code :  you use Mutation!!
        // total is constantly mutating!
        // We spend efforts ion what to do and how to do
        int total = 0;
        for (int e: values) {
            total += e*2;
        }

        System.out.println(total);

        //Declarative style
        System.out.println(
                values.stream()
                        .map( e -> e * 2)
                        .reduce(0,(c,e) -> c + e));
    }

    // Old interface evolved : through default methods
    //Default method is a method implementation, you can write within an interface

}