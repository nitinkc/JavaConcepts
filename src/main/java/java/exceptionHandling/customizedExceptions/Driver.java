package java.exceptionHandling.customizedExceptions;

/**
 * Created by Nitin C on 3/5/2016.
 */
public class Driver {
    public static void main(String[] args) {
        //Compiler wont let the program execute
       // throw new CannotSwimException("Nitin");

        try {
            //throw new CannotSwimException("Nitin executes his custom Exception");
            throw new CannotSwimException();
        } catch (CannotSwimException e) {
            e.printStackTrace();
        }

    }
}
