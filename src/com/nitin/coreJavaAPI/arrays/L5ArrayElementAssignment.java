package com.nitin.coreJavaAPI.arrays;

/**
 * Created by nitin.chaurasia on 12/27/2016.
 * Array Type                  Allaowed eme
 *
 */
public class L5ArrayElementAssignment {
    public static void main(String[] args) {
        // Case 1
        int a[] = new int[10];

        // Case 2 : Object type arrays. Elements can be either declared type or its chils class
        Object b[] = new Object[3];
        b[0] = new Object();
        b[1] = new Integer(10);
        b[2] = new String("Nitin");

        Number c[] = new Number[2];
        c[0] = new Integer(10);
        c[1] = new Double(6.32);

        // Case 3 : Abstract Class Type Arrays. Elemets can be of Child objects
        Number d[] = new Number[2];
        //d[0] = new Number();// abstract cannot be instantiated
        d[0] = new Integer(10);
        d[1] = new Double(6.32);

        // Case 4 : Interface Type Array. elements are implementation class objects
        Runnable r[] = new Runnable[2];
        r[0] = new Thread();

    }

}
