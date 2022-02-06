package nitin.Strings;

/**
 * Created by nitin.chaurasia on 11/21/2016.

 StringBuilder is NON-SYNCHRONIZED thus more efficient
 StringBuffer is SYNCHRONIZED (THREAD SAFE) means two threads
 can call the methods of the object simultaneously. Thus comparatively
 less efficient

 */
public class S3StringBuilder {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder ("test1");
        StringBuffer b = new StringBuffer ("test2");
        String c = "test3";

        a.append(" next1");
        b.append(" next2");
        c = c.concat(" next3");//Not working

        String s = new StringBuilder()
                .append("Nitin").append(" Kumar").append(" Chaurasia")
                .toString();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(s);

    }
}
