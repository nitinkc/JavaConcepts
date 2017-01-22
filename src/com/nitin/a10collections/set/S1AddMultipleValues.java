package com.nitin.a10collections.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by nitin on 1/13/16.
 * Repeated Entries are possible but only the latest one will be kept
 */
public class S1AddMultipleValues {
    public static void main(String[] args) {
        //TreeSet<String> hashSet = new TreeSet<String>();
        HashSet hashSet=new HashSet();
        hashSet.add("B");
        hashSet.add(null);
        hashSet.add("N1PathFileTest");
        System.out.println(hashSet.add("C"));// First Entry TRUE
        System.out.println(hashSet.add("C"));// Second Entry False
        System.out.println(hashSet.add(null));// false, null already added

        System.out.println("****************************************");

        Iterator itr=hashSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
