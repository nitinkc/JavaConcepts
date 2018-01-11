package com.nitin.a.sandBox;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        System.out.println("Testing Maps");

        Map<Integer, String> map = new HashMap<>();

        map.put(1,"Nitin");map.put(2,"Kirti");

        // Gather all the keys in a Set. KEYS ARE ALWAYS UNIQUE
        Set<Integer> keySet = map.keySet();
        // Create an iterator on Set so that values can be retrieved from the Map
        Iterator itr = keySet.iterator();

        while (itr.hasNext()){
            //Key is from the Set
            int key = (int)itr.next();
            //Value is from the Map
            String value = map.get(key);

            System.out.println(key +" - "+ value);
        }

        Iterator itr2 = map.entrySet().iterator();

        while (itr2.hasNext()){
            Map.Entry me = (Map.Entry)itr2.next();
            System.out.println(me.getValue() +" - "+ me.getKey());
        }
    }
}