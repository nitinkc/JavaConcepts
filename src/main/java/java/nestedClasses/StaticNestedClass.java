package java.nestedClasses;

/**
 * Created by Nitin Chaurasia on 3/5/16 at 12:02 AM.
 *
 * Static class defined at the member level
 */
public class StaticNestedClass {
    static class Nested{
        private final int price = 6;
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
    }
}
