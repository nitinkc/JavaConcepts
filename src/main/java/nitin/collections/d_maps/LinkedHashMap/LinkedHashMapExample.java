package nitin.collections.d_maps.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Created by nitin on Monday, October/14/2019 at 1:10 AM
 * Linked HashMap keeps the order of insertion intact
 */
public class LinkedHashMapExample {

    public static void main(String[] args) {
        String str = "The test is from Relativity";

        demo(str);
    }

    // Relativity Assignment in Java8
    //Return a string, ignoring the case of characters like t':5,'h':1,'e':3,' ':4
    public static void demo(String str) {
        //String.chars returns int streams

        Map<Character, Integer> map = new LinkedHashMap<>();
        //BiConsumer<String,Integer> b1 = map::put;
        BiConsumer<Character, Integer> b2 = (k, v) -> {
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        };
        str.chars()
                .mapToObj(i -> (char) i)
                //Ignoring the case
                .map(x -> Character.toLowerCase(x))
                //Putting the character and its count into the map
                .forEach(x -> b2.accept(x, 0));

        String ret = "";
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int i = entry.getValue();

            ret = ret + "'" + c + "'" + ":" + i + ",";
        }

        //Off by one Error : Removing the last Comma
        System.out.println(ret.substring(0, ret.length() - 1));
    }
}