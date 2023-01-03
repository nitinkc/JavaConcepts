package nitin.streams.collectors.c3groupby;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class GroupingBy {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,1,3,3,4,5,6,7,8,6,5,4,3,2,1);

        //Find frequency of all the numbers
        Map<Integer,Long> map = list.stream()
                //.collect(groupingBy(element -> element, counting()));// Function.identity() Equivalent to an i in a for loop
                  .collect(Collectors.groupingBy(Function.identity(), counting()));//collect takes a COLLECTOR as parameter. any method that returns a collector can be used

        System.out.println(map);//{1=3, 2=2, 3=3, 4=2, 5=2, 6=2, 7=1, 8=1}


        // Imperative Style
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (Integer i : list){
            freqMap.put(i,freqMap.getOrDefault(i,0) + 1);
            //countAndPutInMap(freqMap, i);
        }
        System.out.println(freqMap);

        //Collectors is available Since: 1.8
        //Collections class is a member of the Java Collections Framework Since: 1.2
        //Counting By frequency : Collections.frequency()

        Set<Integer> set = new HashSet<>(list);

        for (int i :set){
            int frequency = Collections.frequency(list, i);
            System.out.println(i + " : "+frequency );
        }

    }

    private static void countAndPutInMap(Map<Integer, Integer> freqMap, Integer i) {
        if(freqMap.containsKey(i))
            freqMap.put(i, freqMap.get(i)+1);
        else
            freqMap.put(i,1);
    }
}
