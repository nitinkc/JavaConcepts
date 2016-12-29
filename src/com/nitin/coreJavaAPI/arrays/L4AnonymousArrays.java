package com.nitin.coreJavaAPI.arrays;

/**
 * Created by nitin.chaurasia on 12/27/2016.
 * // Anonymous Array new[]{1,2,3}. We cant declare size as it will give CT error
 */
public class L4AnonymousArrays {
    public static void main(String[] args) {

        //passing anonymous array in sum method
        sum(new int[]{3,4,5,6,7,8,9});
    }

    private static void sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }
        System.out.println(sum);
    }
}
