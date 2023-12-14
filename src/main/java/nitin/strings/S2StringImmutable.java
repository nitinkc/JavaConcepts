package nitin.strings;

/**
 * Created by Nitin C on 11/26/2015.
 */
public class S2StringImmutable {
    /*
    String are made to be immutable as a consequence from Memory Pool concept.
    One string is shared among many variables (due to the String pool concept)
     */

    public static void main(String[] args) {
        String s = "";
        s = "chaurasia";
        System.out.println(s);

        // Proving immutability. s.concat() didnot change the original
        // but created a new a5object and printed. s still points to the original
        System.out.println(s.concat(""));
        System.out.println(s);
    }
    // Object "nitin", "nitin chaurasia" is sent for GC. s now refers to "Chaurasia"
}
