package com.nitin.coreJavaAPI.arrays;

/**
 * Created by Nitin Chaurasia on 12/27/16 at 1:19 AM.
 */
public class L1Array1DDeclarationCreationInit {
    public static void main(String[] args) {
        // Three ways of Declaring
        int []a;
        float[] b;
        int []c;

        //Allocation
        b = new float[3];
        c = new int[2];

        // Allocations & Assigmnment
        // a = {1,2,3,4,5};// Array initializer not allowed here
        a = new int[]{1,2,3,4,5};

        // Assignment type 1
        c[0] = 9 ; c[1] = -3;

        // autoassignment
        for (int i = 0; i < b.length; i++) {
            b[i] = (int) ((i*i) / Math.random());
        }
        // Declaration, Constructions and initialization
        int d[] = {1,2,3,4,5,6};

        // 1D Array Iteration
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i]);
            System.out.print("\t");
        }

        System.out.println();

        // Iteration using for each
        for (int i :
                d) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();

        for (float i :
                b) {
            System.out.print(i);
            System.out.print("\t");
        }
    }
}
