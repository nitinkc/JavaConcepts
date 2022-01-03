package nitin.Strings;


/**
 * Created by nitin.chaurasia on 2/16/2017.
 */
public class S1StringInterning {
    public static void main(String[] args) {

        /* Both the String variables are created on the Stack but reference to the same String on heap */
        String one = "Hello";
        String two = "Hello";

        if (one == two){
            System.out.println("Interning at Work");
        } else {
            System.out.println("Not a String Intern");
        }

        String test1 = "Nitin";
        String test2 = "Nitin";//// Forcing to create a new String
        if (test1 == test2){
            System.out.println("Interning at Work");
        } else {
            System.out.println("Not a String Intern");
        }

        //String three = new String("Nitin");// Forcing to create a new String
        String three = "Nitin".intern();//intern used
        String four = "Nitin";
        if (three == four){
            System.out.println("Interning at Work");
        } else {
            System.out.println("Not a String Intern");
        }
    }
}
