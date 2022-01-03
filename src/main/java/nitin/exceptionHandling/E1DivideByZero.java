package nitin.exceptionHandling;

/**
 * Created by Nitin C on 11/27/2015.
 */
public class E1DivideByZero {
    public static void main(String[] args) {
        int x = 0;
        try{
            x = 5/0;
            //x = 10/5;
        } catch(ArithmeticException e){
            //System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            // Will always execute irrespective on the exception or not
            System.out.println("Always happen");
        }

        // The Program continues from here
        System.out.println(++x);
    }
}
