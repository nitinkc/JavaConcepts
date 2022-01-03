package nitin.exceptionHandling;

/**
 * Created by Nitin C on 11/27/2015.
 */

class X{
    public void m1(){

    }
}
public class E2TwoCatchBlocks {
    public static void main(String[] args) {
        int x = 0;
        X obj = null;
        try{
            obj.m1(); //This occurs first
            x = 5/0;
            x = 10/5;
        }

        // In multiple catch, Child should be on top
        catch(ArithmeticException e){
            System.out.println("Parent Class should be below Child");
            System.out.println(e);
        }
        //Second catch is executed if the AE is not caught.
        catch(Exception e){
            System.out.println(e + "\n" + "Parent Class should be below Child");
        }
        // If there is an exception then ONLY finally will execute
        finally {
            // Will always execute irrespective on the exception or not
            System.out.println("Finally Always happen");
        }

        // To test if finally terminates
        System.out.println("After Finally");

        System.out.println("REST OF THE PROGRAM");
    }

}
