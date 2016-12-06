package com.nitin.sandBox;

/**
 * Created by nitin.chaurasia on 11/21/2016.
 */
public class StringTests {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder ("Nitin");
        StringBuffer b = new StringBuffer ("Priyanka");
        String c = "Ritesh";

        a.append(" Chaurasia");
        b.append(" Pathipati");
        c.concat("Samal");


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
