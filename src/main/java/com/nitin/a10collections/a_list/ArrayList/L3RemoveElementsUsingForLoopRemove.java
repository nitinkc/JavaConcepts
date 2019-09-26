package com.nitin.a10collections.a_list.ArrayList;

import java.util.ArrayList;
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
public class L3RemoveElementsUsingForLoopRemove {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");list.add("B");list.add("C");list.add("D");list.add("E");
        list.add("F");list.add("G");list.add("H");list.add("I");list.add("J");
        //list.remove(2);// Removing the element, from anywhere

        System.out.println("******************* LIST BEFORE REMOVAL ***************************** ");
        System.out.println(list );

        System.out.println("******************* LIST DURING REMOVAL ***************************** ");
        // Removing the elements from the a_list

        // Removal Like this has a bug!!
        //The List reshuffles after each Removal
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.remove(i);
        }

        System.out.println("******************* LIST AFTER REMOVAL ***************************** ");
        System.out.println(list );
    }
}
