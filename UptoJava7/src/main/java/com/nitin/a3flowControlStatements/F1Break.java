package com.nitin.a3flowControlStatements;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 12/27/16 at 1:13 AM.
 */
public class F1Break {
    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(1,2,3,4,5,6,7,8,9);

        for (int i = 0; i < a.size(); i++) {
           /* for (int j = 0; j < i; j++) {
                System.out.println("Inside j loop : " + j);
            }*/
            System.out.print(i + "\t");
            //Breaking out of the loop and performing prints
            if(i == 5)
                break;
            System.out.println("After Break : "  + i);
        }
        System.out.println("After for loop");
    }
}
