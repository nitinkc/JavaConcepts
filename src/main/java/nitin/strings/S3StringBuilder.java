package nitin.strings;

/**
 * Created by nitin.chaurasia on 11/21/2016.
 *
 * <p>StringBuilder is NON-SYNCHRONIZED thus more efficient StringBuffer is SYNCHRONIZED (THREAD
 * SAFE) means two threads can call the methods of the a5object simultaneously. Thus comparatively
 * less efficient
 */
public class S3StringBuilder {
    public static void main(String[] args) {
        String c = "test3";

        String a = "test1" + " next1";
        String b = "test2" + " next2";
        c = c.concat(" next3"); // Not working

        String s = "Nitin" + " Kumar" + " Chaurasia";

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(s);
    }
}
