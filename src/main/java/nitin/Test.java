package nitin;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        /* Make a new empty map */
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        Map<Character, Integer> treeMap = new TreeMap<>();// Natural Ordering is preserved

        String longestEnglishWord = "pneumonoultramicroscopicsilicovolcanoconiosis";

        createMapUsingGetOrDefault(treeMap, longestEnglishWord);
        System.out.println(treeMap);

        createMap(hashMap, longestEnglishWord);
        System.out.println(hashMap);
    }

    private static void createMapUsingGetOrDefault(Map<Character, Integer> treeMap, String longestEnglishWord) {
        for (int i = 0; i < longestEnglishWord.length(); i++) {
            Character key = longestEnglishWord.charAt(i);
             treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);//Notice Default Value 0
        }
    }

    private static void createMap(Map<Character, Integer> hashMap, String longestEnglishWord) {
        for (int i = 0; i < longestEnglishWord.length(); i++) {
            Character key = longestEnglishWord.charAt(i);
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);//Initialize with 1
            } else {
                hashMap.put(key, 1);
            }
        }
    }
}