package com.nitin.collections.list;

import java.util.*;

/**
 * Created by nitin on 1/13/16.
 *
 * The Collections Utility Class provides the method to make a list FINAL
 * READ ONLY. Throws UnsopportedOperationException
 */
public class L1UnmodifiableList {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(13);

        Collection collection = Collections.unmodifiableList(list);
        list.add("123"); //

        collection.add(55);

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
