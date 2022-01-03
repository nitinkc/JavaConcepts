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
        StringBuilder a = new StringBuilder ("Nitin");
        StringBuffer b = new StringBuffer ("Priyanka");
        String c = "Ritesh";

        a.append(" Chaurasia");
        b.append(" Pathipati");
        c.concat("Samal");//Not working


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
