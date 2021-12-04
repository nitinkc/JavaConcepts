package java7.a7oopsConcepts.object.equals;

/**
 * Created by Nitin Chaurasia on 3/4/16 at 11:28 PM.
 */
public class EqualsFailedTest {
    public static void main(String[] args) {
        String str1 = "Nitin";
        String str2 = "Nitin";
        System.out.println(str1.equals(str2));//true

        StringBuilder sb1 = new StringBuilder("Nitin");
        StringBuilder sb2 = new StringBuilder("Nitin");
        /* SB uses implementation of equals provided by Object which just checks reference equality */
        System.out.println(sb1.equals(sb2));//false
    }
}
