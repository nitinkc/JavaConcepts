package nitin.reflectionAPI;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 11:54 PM.
 *
 * <p>There are 3 ways to get the instance of Class class. They are as follows: forName() method of
 * Class class getClass() method of Object class the .class syntax
 */
public class R1BasicRefAPITest {
    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        // For every loaded class, the JVM maintains an associated Class object
        Class reflectionTestClass = null;

        // Type 1: Class.forName() method
        // When "fully qualified Class name" is Known, Class.forName() method is preferred
        reflectionTestClass = Class.forName("nitin.reflectionAPI.ReflectionTestClass");
        System.out.println(reflectionTestClass.getClass());

        // Type 2: Creating the Instance when the Class name and object name both are known!!
        ReflectionTestClass reflectionTestClassObject =
                (ReflectionTestClass) reflectionTestClass.newInstance();
        // Can use parentObject just like when its created with "new" keyword
        System.out.println(
                "Type 2 obj.newInstance() :: " + reflectionTestClassObject.getClass().getName());

        // Type 3: When only the Object Name is known.
        // It should be used if you know the type. Moreover, .getClass can be used with primitives.
        Class c1 = reflectionTestClassObject.getClass();
        System.out.println("Type 3 obj.getClass() :: " + c1.getName());
    }
}
