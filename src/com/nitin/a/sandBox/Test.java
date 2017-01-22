package com.nitin.a.sandBox;

import sun.applet.resources.MsgAppletViewer;

import java.nio.file.DirectoryIteratorException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Nitin Chaurasia on 12/15/16 at 10:32 PM.
 */
public class Test {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("Nitin", 31);
        map.put("Sangram", 26);
        map.put("Ramdon", 30);

        // Reading a map
         // We need a set to collcet all the String values
        // We will iterate over the keySet

        Iterator<String> itr = map.keySet().iterator();

        while(itr.hasNext()){
            String key = itr.next();
            int value = map.get(key);

            System.out.println("key = " + key + " |  Value = " + value);
        }

    }
}
