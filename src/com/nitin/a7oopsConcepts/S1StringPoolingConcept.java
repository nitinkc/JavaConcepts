package com.nitin.a7oopsConcepts;

/**
 * Created by Nitin C on 11/26/2015.
 */
public class S1StringPoolingConcept {
    public static void main(String []args){
        // Two ways of Creating a String (new and "~~~")
        String s = new String("nitin");
        String x = "nitin";
        String y = "nitin";

        String s1 = "nitin";
        String s2 = "nitin";
        String s3 = "nitin";
         /*
        When we use double quotes to create a string, it first looks
        for the string with the same value in the String Pool. If found it
        just returns the reference

         It does so for conserving memory
         FLYWAY DESIGN PATTERN.
        */

        String s4 = new String("nitin");
        String s5 = new String("nitin");
        /*
        String s4 and s5 are two different String objecs lying in
        the "Heap"
         */

        if (x == y) {
            System.out.println("x and y are referring to a same String");
        }
        /** In Sting .equals() method checks for string equality
         * = compared the references
         */
    }
}
