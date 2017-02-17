package com.nitin.garbageCollection;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by nitin.chaurasia on 2/16/2017.
 */
public class StringInterning {
    public static void main(String[] args) {
        String one = "Hello";
        String two = "Hello";
        // Both the String variables are created on the Stack but reference to the same String on heap

        if (one == two){
            System.out.println("Interning at Work");
        } else {
            System.out.println("Not a String Intern");
        }

        //String three = new String("Nitin");// Forcing to create a new String
        String three = new String("Nitin").intern();//intern used
        String four = "Nitin";
        if (three == four){
            System.out.println("Interning at Work");
        } else {
            System.out.println("Not a String Intern");
        }
    }
}
