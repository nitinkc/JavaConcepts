package nitin.generic.oReilly.a1Inheritance;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nichaurasia on Friday, May/15/2020 at 11:43 PM
 */

public class C3GenericWRTInheritence {
    public static void main(String[] args) {
        List<Number> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sumList(numbers));

        //The Inheritance process is NOT LEGAL between the collections.
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        /* Even though Integer is Child class of Number, the below is illegal */
        //System.out.println(sumList(ints));
        /* incompatible types: java.util.List<java.lang.Integer> cannot be converted to java.util.List<java.lang.Number> */

        //THIS PROBLEM IS RESOLVED WITH WILDCARDS
    }

    //Sum List accepts a List of numbers whihc is a super class of all the numbers (see Read me)
    private static int sumList(List<Number> numbers) {
        return numbers.stream()
                //.mapToInt(x -> x.intValue())
                .mapToInt(Number::intValue)
                .sum();
    }
}
