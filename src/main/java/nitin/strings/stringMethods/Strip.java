package nitin.strings.stringMethods;

/**
 * @author Created by nichaurasia Create on Sunday, December/20/2020 at 7:19 PM
 */
public class Strip {
    public static void main(String[] args) {
        System.out.println(" nitin ".trim() + "#####"); // spaces at both ends
        System.out.println(" nitin".trim() + "#####"); // leading space
        System.out.println("nitin ".trim() + "#####"); // trailing space

        // strip() is Unicode-aware
        System.out.println("*************** STRIP ***************");

        System.out.println(" nitin ".strip() + "#####"); // spaces at both ends
        System.out.println(" nitin ".stripLeading() + "#####"); // leading space
        System.out.println(" nitin ".stripTrailing() + "#####"); // trailing space
    }
}
