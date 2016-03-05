package com.nitin.collections.iterators;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by nitin on 1/13/16.
 *
 * Enumeration is used with the Legacy Datastructures like Vector and HashTable
 */
public class I1EnumerationDemo {
    public static void main(String[] args) {
        Hashtable map = new Hashtable();
        map.put(1, "Abc");
        map.put(2, "REMOVED!!");
        map.put(3, "Abc");

        map.entrySet();

        Enumeration enumeration = map.elements();
        while (enumeration.hasMoreElements()) {
            map.remove(2);
            System.out.println(enumeration.nextElement());
        }
    }
}
