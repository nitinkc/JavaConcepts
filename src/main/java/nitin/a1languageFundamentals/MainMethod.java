package nitin.a1languageFundamentals;

/**
 * Created by Nitin Chaurasia on 12/28/16 at 1:19 AM.
 * public : Call by JVM from anywhere
 * static : JVM can call this even without existing Object
 * void : main method can't return anything to JVM
 * main : name of the method which is configured inside JVM (can be tweaked)
 * String[] args : Array of command line String arguments
 * <p>
 * Can be declared with final, synchronized and strictfp
 * Inheritance Concept is applicable
 */
public class MainMethod {
    /*final*/
    static synchronized strictfp public void main(String[] args) {
        System.out.println("Parent Testing");
    }
}

class ChildMain extends MainMethod {//method hiding

    static synchronized strictfp public void main(String[] args) {
        System.out.println("Child Testing");
    }

}
