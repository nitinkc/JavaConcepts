package java.accessModifiers;

/**
 * Created by Nitin Chaurasia on 12/29/16 at 12:55 AM.
 */
public abstract class M2Abstract {

    // Allowed only on Classes and Methods, not on variables

    // Abstract method just has declaraton, thus ends in ;
    // Any class extending abstract class, has to provide the implementation.

    // abstract call cannot be instantiated. Thus if we don't want a class to be instantiated, declare it as abstract.

    // If a class has at least one abstract method, The class has to be declared as abstract.

    // even if there are no abstract methods in a class, we can still declare it as abstract. eg. HTTPServlet

    // Final class cant have abstract method
    public abstract void method();
}
