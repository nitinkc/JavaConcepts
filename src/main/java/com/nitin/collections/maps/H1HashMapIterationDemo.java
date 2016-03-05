package com.nitin.collections.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by nitin on 1/13/16.
 */
public class H1HashMapIterationDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"India");
        map.put(2,"USA");
        map.put(3,"Austria");
        map.put(4,"China");
        map.put(5,"Iran");

        // Method 1: take the keyset and pick value 1 by 1
        Set set = map.keySet();//Take the keyset out
        Iterator itr = set.iterator();

        while (itr.hasNext()){
            System.out.println(map.get(itr.next()));
        }

        System.out.println("*************************************");
        // Method 2: Run the Entry
        Set entry = map.entrySet();
        Iterator itr2 = entry.iterator();
        // Can be written as
        //Iterator itr3 = (Iterator) map.entrySet();

        while(itr2.hasNext()){
            Map.Entry me = (Map.Entry) itr2.next();
            System.out.println(me.getKey() +" - " + me.getValue());
        }

        System.out.println("*************************************");
        /* Method 3: Iteration by map entry */
        for (Map.Entry<Integer,String> entry1 : map.entrySet()) {
            System.out.println(entry1.getKey() + " - " + entry1.getValue());
        }
    }
}
