package com.nitin.a10collections.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by synergisticit on 2/25/2016.
 *
 * HashMAp and HashSet doest guarantee the ordre of retieval
 * TreeSet and TreeMap guarantees order (for map, the order is DNSO of keys)
 */
public class BasicMapInteger {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        map.put(1008,1234567891);
        map.put(1001,4);
        map.put(1002,2);
        map.put(1003,6);
        map.put(1004,9);
        map.put(1005,10);
        map.put(1006,11);
        map.put(1007,12);


        //printMapUsingSet(map);

        //printMapUsingEntrySet(map);
        removeOddNumber(map);

        printMapUsingEntrySetForEach(map);



    }

    private static void removeOddNumber(Map<Integer, Integer> map) {
        //KeySet is a method in Map which RETURNS SET OF KEYS

        Iterator<Integer> itr = map.keySet().iterator();
        while(itr.hasNext()) {
            int tempKey = itr.next();
            if(map.get(tempKey)%2 == 0){
                // Concurrent Modification Exception
                //map.remove(tempKey);

                //ALWAYS REMOVE USING ITERATOR
                itr.remove();
            }
        }
    }

    private static void printMapUsingEntrySetForEach(Map<Integer, Integer> map) {
        //loop a Map
        for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
            System.out.println("Key : " + itr.getKey() + " Value : " + itr.getValue());
        }
    }

    /**
     * Iterating thrugh a Map using Entry Set.
     * NOTE: ENTRY SETRETURNS N1PathFileTest SET OF ENTRY WHICH KEY ADN VALUE
     * @param map
     */
    private static void printMapUsingEntrySet(Map<Integer, Integer> map) {
        //Extracting the entry set and iterating over it
        Set myMap = map.entrySet();
        Iterator<Map.Entry<Integer,Integer>> itr = myMap.iterator();

        while(itr.hasNext()) {
            Map.Entry curr = itr.next();
            //Return the toString representation of Map.Entry
            System.out.println(curr);
            //Extracting the key and value out of Entry
            System.out.println("Key is : "+curr.getKey()+" Value is "+curr.getValue());
        }
    }

    /**
     * Map is not a part of Collection thus Iterator is not available
     *
     * There are two ways to iterate a map
     * 1. Using Set (for loop)
     * 2. Using EntrySet (for each)
     * @param map
     */
    private static void printMapUsingSet(Map<Integer, Integer> map) {
        //KeySet is a method in map which RETURNSD N1PathFileTest SET OF KEYS
        Set<Integer> key = map.keySet();

        Iterator itr = key.iterator();
        while(itr.hasNext()) {
            Integer tempKey = (Integer)itr.next();
             System.out.print("Value is : "+map.get(tempKey) + ", key is : "+ tempKey + "\n");
        }
    }
}
