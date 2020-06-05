package com.nitin.a10collections.d_maps;

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

        // Method 1: KETSET Method : take the keyset and pick value 1 by 1
        //  Set b_set = map.keySet();//Take the keyset out

        // Gather all the keys in a Set. KEYS ARE ALWAYS UNIQUE
        Set<Integer> keySet = map.keySet();
        // Create an iterator on Set so that values can be retrieved from the Map
        Iterator itr = keySet.iterator();

        // ***************** COMBINING ABOVE TWO*********************8
        //Iterator itr = map.keySet().iterator();

        while (itr.hasNext()){
            //Key is from the Set
            int key = (int) itr.next();
            //Value is from the Map
            String value = map.get(key);
            System.out.print("Key = " + key );
            System.out.println("  Value = " + value);
        }

        System.out.println("*************************************");

        // Method 2: Entry Set method : run the Entry Set
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
