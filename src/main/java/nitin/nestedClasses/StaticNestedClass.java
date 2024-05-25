package nitin.nestedClasses;

/**
 * Created by Nitin Chaurasia on 3/5/16 at 12:02 AM.
 * <p>
 * Static class defined at the member level
 */
public class StaticNestedClass {
    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
    }

    static class Nested {
        private final int price = 6;
    }
}
