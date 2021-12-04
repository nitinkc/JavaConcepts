package java7.a7oopsConcepts;

/**
 * Created by Nitin C on 11/26/2015.
 */
public class S3CharArrayToString {
    public static void main(String[] args) {
        char[] a = {'a','b','c'};

        //String constructor that takes charArray
        String data = new String(a);
        System.out.print(data);
    }
}
