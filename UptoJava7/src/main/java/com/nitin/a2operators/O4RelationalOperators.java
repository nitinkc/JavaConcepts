package com.nitin.a2operators;

/**
 * Created by Nitin Chaurasia on 12/28/16 at 9:50 PM.
 */
public class O4RelationalOperators {
    public static void main(String[] args) {
        System.out.println(10 > 20);
        // System.out.println("Nitin" > "Nitiin");// can't be applied on Strings
        // System.out.println(true > false);// can't be applied on boolean
        System.out.println(10 >= 10.0);
        // System.out.println(10 > 9 > 8);// true > 8 fails

        int x = 10, y = 20, z = 10;
        System.out.println(x < y); // Outputs true
        System.out.println(x <= y); // Outputs true
        System.out.println(x >= z); // Outputs true
        System.out.println(x > z); // Outputs false
    }
}
