package com.nitin.Aug2615;

/**
 * Created by Nitin C on 11/26/2015.
 */
public class S4StringBufferVsStringBuilder {
    public static void main(String[] args) {
        StringBuilder sbuild = new StringBuilder(); // Empty String with initial capacity 16

        /*
        StringBuilder is NON-SYNCHRONIZED thus more efficient
        StringBuffer is SYNCHRONIZED (THREAD SAFE) means two threads
        can call the methods of te object simultaneously. Thus comparatively
        less efficient
         */


    }
}
