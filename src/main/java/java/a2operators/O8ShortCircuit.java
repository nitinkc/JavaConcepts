package java.a2operators;

/**
 * Created by Nitin Chaurasia on 12/28/16 at 10:32 PM.
 * && and || : just to improve the performance of the system.
 * Applicable only for Boolean type.
 * second operand evaluation is optional
 */
public class O8ShortCircuit {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        if (a[1] > a[0] | a[3] > a[2]) // both operands are checked
            System.out.println("success");

        if (a[1] > a[0] && a[3] > a[2]) // only necessary operands are checked
            System.out.println("success");

        int x = 10;

        if ( (++x < 10) && (x/0 > 10)) // the Arithmatic Exception is not even evaluated
            System.out.println("inside If");
        else
            System.out.println("Inside Else");

        if ( (++x < 10) & (x/0 > 10)) // the Arithmatic Exception is thrown as x/0 is checked
            System.out.println("inside If");
        else
            System.out.println("Inside Else");
    }
}
