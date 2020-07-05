package com.nitin.a10collections.a_list.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nitin on 1/13/16.
 * ArrayList arrayList=new ArrayList(11);
 * ArrayList Initial Size 10; Later incremented by 3/2 + 1
 * Vector Initial Size 16; Incremented by 2X
 *
 * list.remove() --> ConcurrentModificationException id used with Iterator
 * itr.remove() --> correct way to remove
 */
public class L3RemoveElementsUsingForEachRemove {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        list.remove(2);// Removing the element, from anywhere

        System.out.println("******************* LIST BEFORE REMOVAL ***************************** ");
        System.out.println(list );

        System.out.println("******************* LIST DURING REMOVAL ***************************** ");
        // Removing the elements from the a_list

        //FOR EACH is a Read Only Loop, so it will end in ConCurrent modification exception
        for (String str: list) {
            System.out.println(str);
            list.remove(str);//ConcurrentModificationException
        }

        System.out.println("******************* LIST AFTER REMOVAL ***************************** ");
        System.out.println(list );
    }
}
