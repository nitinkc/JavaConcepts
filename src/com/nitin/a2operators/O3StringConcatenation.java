package com.nitin.a2operators;

/**
 * Created by Nitin Chaurasia on 12/28/16 at 9:46 PM.
 */
public class O3StringConcatenation {
    public static void main(String[] args) {
        String str = "Nitin";
        int a = 10, b = 20, c = 30;

        // Concatenation in action
        System.out.println(a+b+c+str);
        System.out.println(a+str+b+c);
        System.out.println(a+b+str+c);
        System.out.println(str+a+b+c);


    }
}
