package nitin.strings;


/**
 * Created by nitin.chaurasia on 2/16/2017.
 */
public class S1StringInterning {
    public static void main(String[] args) {

        /* Both the String variables are created on the Stack but reference to the same String on heap */
        String one = "Hello";
        String two = "Hello";

        testIntern(one, two);

        String test1 = "Nitin";
        String test2 = "Nitin";//// Forcing to create a new String
        testIntern(test1, test2);

        String three = "Nitin";// Forcing to create a new String
        //String three = "Nitin".intern();//intern used
        String four = "Nitin";
        testIntern(three, four);
    }

    private static void testIntern(String one, String two) {
        if (one == two) {
            System.out.println("Interning at Work");
        } else {
            System.out.println("Not a String Intern");
        }
    }
}
