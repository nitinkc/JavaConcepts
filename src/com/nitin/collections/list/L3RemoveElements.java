package com.nitin.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nitin on 1/13/16.
 * ArrayList arrayList=new ArrayList(11);
 * ArrayList Initial Size 10; Later incremented by 3/2 + 1
 * Vector Initial Size 16; Incremented by 2X
 *
 * list.remove() --> ConcurrentModificationException
 * itr.remove() --> correct way to remove
 */
public class L3RemoveElements {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        list.remove(1);// Removing the element

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            //itr.remove();// Wrong Place as the itr is accessed in SOP
            //list.remove(1);//ConcurrentModificationException
            System.out.println(itr.next());
            itr.remove();
        }// The list will be empty after this
    }
}
