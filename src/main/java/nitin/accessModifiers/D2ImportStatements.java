package nitin.accessModifiers;

/**
 * Created by Nitin Chaurasia on 12/29/16 at 12:24 AM.
 * Explicit Class Import : all classes are written, highly recommended
 * Implicit Class import : not recommended. (import java.util.*)
 * <p>
 * Dynamic Loading OR Load On Demand OR Load On Fly
 * <p>
 * Static Import : From Java 1.5, Static imports are also possible. But it reduces readability
 */

//Static Import

import static java.lang.Float.MAX_VALUE;
import static java.lang.Math.*;

public class D2ImportStatements {
    public static void main(String[] args) {

        //Static Imports (not recommended )
        System.out.println(sqrt(9));
        System.out.println(random() * 10);
        System.out.println(max(10, 23));

        // Ambiguity
        System.out.println(MAX_VALUE); //Error: reference to MAX_VALUE is ambiguous
        //both variable MAX_VALUE in java.lang.Float and variable MAX_VALUE in java.lang.Integer match
    }
}
