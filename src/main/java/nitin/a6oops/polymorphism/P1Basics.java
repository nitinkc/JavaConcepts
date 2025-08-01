package nitin.a6oops.polymorphism;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** Created by nitin on Sat, 1/14/17 at 6:36 PM. */
public class P1Basics {
    public static void main(String[] args) {

        /* Object of same class (List) but behave differently and behaviour depends on object being invoked */
        List linkedList = new LinkedList();
        List arrayList = new ArrayList();

        // Always occurs with Inheritance with a special case
        // child behaviour is changed hiding parent

        // Treat an object of any subclass as if it were an object of parent class

        // Dynamic binding makes polymorphism possible. Compiler is not able to resolve the call.
        // Binding
        // id done at runtime

        // Binding : Relating a method call to a method

        /* Static Binding or Overloading: Happens in compile time
         * uses type information (class in Java) for binding, binding -> relating methods to methods calls
         * private, static, final, static variables } methods, not participation in polymorphism
         */

        /* Dynamic Binding : all instance methods
         * Virtual methods are bounded during runtime object
         * No concept of compile time polymorphism.
         */
    }
}
