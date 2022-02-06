package nitin.collections.d_maps.HashMap;

import java.util.*;

public class HashMapRevisions {

    public static void main(String[] args) {
        int[] a = new int[]{10, 20, 30, 40, 50, 60, 70, 80};
        int target = 150;
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        //Putting in the int array in the HashMap
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], target - a[i]);
        }

        Iterator<Integer> itr = map.keySet().iterator();
        while (itr.hasNext()) {
            int key = itr.next();
            int value = map.get(key);

            //Bug: Fails if target/2 exist in the Array
            if (map.containsKey(value)) {
                list.add(key);
            }
        }
        System.out.println(list.toString());
    }
}