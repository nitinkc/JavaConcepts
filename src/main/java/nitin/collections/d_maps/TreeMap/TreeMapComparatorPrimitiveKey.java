package nitin.collections.d_maps.TreeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapComparatorPrimitiveKey {

    // Using Default Comparator
    public static void main(String[] args) {
        Map<Integer, String> map =
                new TreeMap<>(
                        new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                return (o2 - o1);
                            }
                        });

        String[] arr = new String[] {"", "kumar", "chaurasia"};

        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(
                    "Key is : " + entry.getKey() + " And value is : " + entry.getValue());
        }
    }
}
