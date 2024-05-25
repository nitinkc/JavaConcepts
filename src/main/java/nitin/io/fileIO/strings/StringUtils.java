package nitin.io.fileIO.strings;

public class StringUtils {

    private StringUtils() {
    } // Uninstantiatable class: static methods only

    /**
     * Returns a reversed copy of a non-null String.
     */

    public static String reverseString(String s) {
        return (new StringBuilder(s).reverse().toString());
    }

    /**
     * Checks if a String is a palindrome. Accepts
     * zero-length or one-length strings, but not null.
     */
    public static boolean isPalindrome(String s) {
        return (s.equalsIgnoreCase(reverseString(s)));
    }
}
