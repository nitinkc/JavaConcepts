package nitin.exceptionHandling;

/**
 * Created by Nitin C on 11/27/2015.
 * <p>
 * Finally executes even after the return occurs from catch block
 * Finally runs even after throws
 */
public class E3FinallyMagic {
    public static void main(String[] args) {

        try {
            int i = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e);
            e.printStackTrace();//behaves like coming from a separate thread
            return;// Finally happens even after the return
        } finally {
            System.out.println("It executes even after return from catch");
        }
    }

}
