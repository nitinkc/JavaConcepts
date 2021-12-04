package java7.a7oopsConcepts;

/**
 * Created by Nitin C on 11/26/2015.
 */
public class S4StringBufferVsStringBuilder {
    public static void main(String[] args) {
        StringBuilder sbuild = new StringBuilder(); // Empty String with initial capacity 16

        /*
        StringBuilder is NON-SYNCHRONIZED thus more efficient
        StringBuffer is SYNCHRONIZED (THREAD SAFE) means two threads
        can call the methods of the object simultaneously. Thus comparatively
        less efficient
         */


    }
}
