package com.nitin.a7exceptionHandling.commonExceptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nitin on 1/13/16.
 * While iterating the list, if the STRUCTURE IS modified.
 */
public class E2ConcurrentModification {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("N1PathFileTest");
        list.add("B");

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            list.remove(1);//Will Work as its currently being pointed
            list.remove(2);//ConcurrentModificationException
        }
    }
}
