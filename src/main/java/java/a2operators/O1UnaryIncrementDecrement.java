package java.a2operators;

/**
 * Created by Nitin Chaurasia on 12/28/16 at 8:23 PM.
 * Pre-Increment ++x
 * Post-Increment x++
 * Pre-Decrement --x
 * Post-Decrement  x++
 *
 * Nesting not possible ++(--x) -> Compile time error
 * Can be applied to all primitive type except boolean
 */
public class O1UnaryIncrementDecrement {
    public static void main(String[] args) {
        int x = 5, y = -99999;
        y = x++; // First assign val of x to y, and then increment
        System.out.println("x = " + x + " y = " + y);//x = 6 y = 5

        x = 5; //reset the value of x
        y = ++x;// First increment x, then assign it to y
        System.out.println("x = " + x + " y = " + y);//x = 6 y = 6

        x = 5; //reset the value of x
        y = x--;// First assign x to y, then increment it
        System.out.println("x = " + x + " y = " + y);//x = 4 y = 5

        x = 5; //reset the value of x
        y = --x;// First decrement x, then assign it to y
        System.out.println("x = " + x + " y = " + y);//x = 4 y = 4

        // Can be applied to all primitive type except booleanCan be applied to all primitive type except boolean
        char ch = 'a';
        System.out.println(++ch);// b, Increment ch and then print

        System.out.println(0/0.0); // Not a Number
        int counter = 0;
        System.out.println(counter); // Outputs 0
        System.out.println(++counter); // Outputs 1
        System.out.println(counter); // Outputs 1
        System.out.println(counter--); // Outputs 1
        System.out.println(counter); // Outputs 0
    }
}
