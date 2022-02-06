package nitin.a1languageFundamentals.variables;

/**
 * Created by Nitin Chaurasia on 12/28/16 at 12:25 AM.
 * 1. Instance Variable
 * # Also known as Object level variables or attributes
 * # For each object, a separate copy of variable is maintained
 * # created at the time of object creation and destroyed at time of object destruction
 * # declared within the class BUT outside any constructor, block or method
 * # not required to perform initialization explicitly, JVM provides default values
 * # scope: Same as Object
 * 2. Static Variable
 * # Stored in method area. Thus called class-level or fields
 * # Values remains same between all objects. Single copy is created
 * # Created at the time of Class Loading and destroyed at class unloading
 * # since created at the time of loading, can access from both instance &amp; static areas directly
 * # declared with staticTest keyword, within the class BUT outside any constructor, block or method
 * # not required to perform initialization explicitly, JVM provides default values
 * # Scope : same as class
 * 3. Local Variable
 * # aka Stack variable or automatic variable
 * # scope : Block level scope
 * # need to initialize. Error: variable local might not have been initialized
 * # Only applicable modifier is FINAL. private, public, protected, static Not allowed
 */
public class PurposeNPositionOfDeclaration {
    /* Instance Variables */
    String s;
    int x;
    boolean bool;

    /* Static Variables */
    static int s1 = 10;
    static int s2;


    public static void main(String[] args) {

        PurposeNPositionOfDeclaration obj = new PurposeNPositionOfDeclaration();
        // since created at the time of loading, can access from both instance & static areas directly
        System.out.println(s1);

        // Local Variable
        int local = 0;
        final double PI = 3.14;
        System.out.println(local);
        System.out.println(PI);
    }

    public void m() {
        // since created at the time of loading, can access from both instance & static areas directly
        System.out.println(s2);
    }
}
