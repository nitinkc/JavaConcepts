package com.nitin.a4coreJavaAPI.Strings;

/**
 * Created by nitin on Thu, 12/29/16 at 2:46 AM.
 */
public class S1StringPool {
    public static void main(String[] args) {

        String a = "In String Pool"; // JVM uses the String Pool
        String b = new String("Don't use String Pool");//
    }
}
