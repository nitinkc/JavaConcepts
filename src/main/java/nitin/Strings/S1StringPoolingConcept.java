package nitin.Strings;

/**
 * Created by Nitin C on 11/26/2015.
 */
public class S1StringPoolingConcept {
    public static void main(String []args){
        // Two ways of Creating a String (new and "~~~")
        String s = "";
        String x = "";
        String y = "";

        String s1 = "";
        String s2 = "";
        String s3 = "";
         /*
        When we use double quotes to create a string, it first looks
        for the string with the same value in the String Pool. If found it
        just returns the reference

         It does so for conserving memory
         FLYWAY DESIGN PATTERN.
        */

        String s4 = "";
        String s5 = "";
        /*
        String s4 and s5 are two different String objecs lying in
        the "Heap"
         */

        if (x == y) {
            System.out.println("x and y are referring to a same String");
        }
        /** In Sting .equals() method checks for string equality
         * = compared the references
         */
    }
}
