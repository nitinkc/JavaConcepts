package com.nitin.a.sandBox;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author Created by nichaurasia
 * @create on Tuesday, January/19/2021 at 6:39 PM
 */

public class Fix45 {
    public static void main(String[] args) {
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c",new String[]{"a"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> countMap = new HashMap<>();

        //removing all punctuation
        paragraph = paragraph.replaceAll("[^a-zA-Z ]", "");
        //making a String Array, with words separated with space
        String str[] = paragraph.toLowerCase().split("\\s+");

        for (String s : str) {
            if (countMap.containsKey(s)) {
                countMap.put(s, countMap.get(s) + 1);
            } else {
                countMap.put(s, 1);
            }
        }

        //Arranging the countMap with Descending order of the values
        Map<String, Integer> sortedMap = new HashMap<>();

        countMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        //remove banned words from the sorted map;
        for (String s : banned) {
            sortedMap.remove(s);
        }

        Iterator<String> itr = sortedMap.keySet().iterator();

        int maxKey = -1;
        String val = "";
        while (itr.hasNext()) {
            String key = itr.next();
            int value = sortedMap.get(key);

            if (value > maxKey) {
                maxKey = value;
                val = key;
            }
        }
        return val;
    }
}