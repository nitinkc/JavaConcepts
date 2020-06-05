package com.nitin.kcura.oldSolution.part2;

import java.util.Comparator;

/**
 * Created by Nitin Chaurasia on 11/10/15.
 *
 * Based on the Assumption given in the Exercise, The same city will not
 * appear more than once in the input file and thus it can safely be deduced that
 * The total nmver of times an interstate name appears in the input file is equal to
 * the total number of different cities is passes through
 */
public class InterstateComparator implements Comparator<String > {

    public static final int BIGGER = 1;
    public static final int SMALLER = -1;
    public static final int EQUAL = 0;

    /*  Sort the List of Interstates based on the Interstate number
     */

    @Override
    public int compare(String obj1, String obj2) {
        //Take the number out of the String for comparison

        //Based on the exercise, all Interstates will begin with prefix I-
        // Taking out the integer from name e.g I-25 will give 25
        int num1 = Integer.parseInt(obj1.substring("I-".length(),obj1.length()));
        int num2 = Integer.parseInt(obj2.substring("I-".length(),obj2.length()));

        if (num1 > num2) {
            return BIGGER;
        } else if (num1 < num2){
            return SMALLER;
        }
        else{
            throw new IllegalArgumentException("Two Interstates with same name in a Same City");
        }
    }
}
