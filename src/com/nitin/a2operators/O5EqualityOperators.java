package com.nitin.a2operators;

/**
 * Created by Nitin Chaurasia on 12/28/16 at 9:55 PM.
 * == equal to (if two objects are same, then its true)
 * != not equal to
 */
public class O5EqualityOperators {
    public static void main(String[] args) {
        String s1 = new String("Nitin");
        String s2 = "Nitin";
        //Reference Testing
        System.out.println(s1 == s2);// False as the two objects are different
        System.out.println(s1.equals(s2));// String equality testing

        Object o1 = new Object();
        Thread t1 = new Thread();

        // System.out.println(t1 == s1);//Incompatible type

        // There should be some relationship between comparing objects
        System.out.println(t1 == o1);
        System.out.println(o1 == t1);

        System.out.println(t1 == null);// False always as an obj is pointing to a memory location.
        System.out.println(null == null);// Always true;

    }
}
