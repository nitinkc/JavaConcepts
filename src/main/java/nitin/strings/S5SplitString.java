package nitin.strings;

import java.util.Arrays;

/**
 * Created by Nitin Chaurasia on 3/23/18 at 11:22 PM.
 */
public class S5SplitString {
    public static void main(String[] args) {
        String myString = "Nitin x Kirti x Nidhi x Niti";
        String[] splitString = myString.split("x");

        System.out.println(Arrays.toString(splitString));
    }
}
