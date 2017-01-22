package com.nitin.a10collections.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by synergisticit on 2/25/2016.
 */
public class addSameKeyMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1,"abc");
        map.put(2,"abc");
        map.put(1,"Sangram"); // overwritten

        Iterator<Integer> itr= map.keySet().iterator();

        while (itr.hasNext()){
            int key = itr.next();
            System.out.println(key + "  -  " + map.get(key) );
        }
    }
}
