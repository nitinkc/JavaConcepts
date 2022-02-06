package nitin.nestedClasses.innerClass;

/**
 * Created by Nitin C on 3/5/2016.
 * <p>
 * Local Inner Classes have following properties
 * 1. No access specifiers
 * 2. Cannot be declared static and cannot declare static fields or methods
 * 3. They have access of all the fields and methods of the enclosing class
 * 4. ONLY have access to "local variable" which are final or effectively final
 */
public class I2LocalInnerClass {
    int length = 5;

    public void calculate() {

        int width = 20; // Effectively final local variable, as it is not reassigned
        // width = 30; error as effectively final or only final variables are allowed inside inner class
        length = 6;// Re assignment of instance variable

        class Inner {
            public void area() {
                System.out.println(length * width);
            }
        }
        Inner inner = new Inner();
        inner.area();// Calling the area() of the inner with the method of the
    }

    public static void main(String[] args) {
        I2LocalInnerClass outer = new I2LocalInnerClass();
        outer.calculate();
    }
}
