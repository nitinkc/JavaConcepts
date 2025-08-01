package nitin.arrays;

/**
 * Created by nitin.chaurasia on 12/27/2016. Array Type | Allowed elements 1. Primitive Type Arrays
 * | Any type which can be implicitly promoted to declared type 2. Object Type Arrays | Either
 * declared type objects or its child class objects 3. Abstract Class Type | Child class objects are
 * allowed 4. Interface Type Arrays | Implementation class objects are allowed
 */
public class L5ArrayElementAssignment {
    public static void main(String[] args) {
        // Case 1
        int[] a = new int[10];

        // Case 2 : Object type arrays. Elements can be either declared type or its child class
        Object[] b = new Object[3];
        b[0] = new Object();
        b[1] = Integer.valueOf(10);
        b[2] = "Nitin";

        Number[] c = new Number[2];
        c[0] = Integer.valueOf(10);
        c[1] = Double.valueOf(6.32);

        // Case 3 : Abstract Class Type Arrays. Elements can be of Child objects
        Number[] d = new Number[2];
        // d[0] = new Number();// abstract cannot be instantiated
        d[0] = Integer.valueOf(10);
        d[1] = Double.valueOf(6.32);

        // Case 4 : Interface Type Array. elements are implementation class objects
        Runnable[] r = new Runnable[2];
        r[0] = new Thread();
    }
}
