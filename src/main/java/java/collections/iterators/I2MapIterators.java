package java.collections.iterators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by synergisticit on 2/25/2016.
 *
 * 4 ways of iterating the Map
 */
public class I2MapIterators {
    public static void main(String[] args){
       Map<String,Integer> map= new HashMap<>();
        map.put("sangram",1);
        map.put("gram",1);
        map.put("m",3);
        map.put("am",4);
        map.put("ngram",5);

        //printUsingKeySet(map);
        //printUsingEntrySet(map);
        //printUsingKeySetForEach(map);
        printUsingEntrySetForEach(map);

    }

    private static void printUsingEntrySetForEach(Map<String, Integer> map) {
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            System.out.println("Key is= "+entry.getKey()+" value= "+entry.getValue());
        }

    }

    private static void printUsingKeySetForEach(Map<String, Integer> map) {
        for (String key:map.keySet()) {
            System.out.println("Key is= "+key+" value= "+map.get(key));
        }

    }

    private static void printUsingEntrySet(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> itr= map.entrySet().iterator();

        while(itr.hasNext()){
            Map.Entry<String ,Integer> temp = itr.next();
            String key = temp.getKey();
            int value = temp.getValue();
            System.out.println("key is : " +key+" - Value is:"+value);
        }
    }


    private static void printUsingKeySet(Map<String, Integer> map) {
        Iterator<String> itr= map.keySet().iterator();

        while(itr.hasNext()){
            String key = itr.next();
            int value = map.get(key);
            System.out.println("key is : " +key+" - Value is:"+value);
        }
    }
}
