package nitin.streams.collectors.c3groupby;

import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class FrequencyCalc {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 3, 4, 5, 6, 7, 8, 6, 5, 4, 3, 2, 1);

        //Find frequency of all the numbers using groupBy and streams
        frequencyByGroupingBy(list);

        //Collectors is available Since: 1.8
        //Collections class is a member of the Java Collections Framework Since: 1.2

        //Counting By frequency : Collections.frequency()
        freqWithCollectionsFrequency(list);

        // Imperative Style frequency calculation
        frequencyWithMap_Old(list);
        frequencyWithGetOrDefault(list);
    }

    private static void frequencyByGroupingBy(List<Integer> list) {
        Map<Integer, Long> freqMapStreams = list.stream()
                //.collect(groupingBy(element -> element, counting()));// Function.identity() Equivalent to an i in a for loop
                .collect(Collectors.groupingBy(Function.identity(), counting()));//collect takes a COLLECTOR as parameter. any method that returns a collector can be used
        System.out.println(freqMapStreams);//{1=3, 2=2, 3=3, 4=2, 5=2, 6=2, 7=1, 8=1}
    }

    private static void frequencyWithGetOrDefault(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer x : list) {
            map.put(x, map.getOrDefault(x, 0) + 1);//default to 0 and adding 1
        }
        System.out.println(map);
    }

    private static void freqWithCollectionsFrequency(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i : list) {
            int frequency = Collections.frequency(list, i);
            frequencyMap.put(i, frequency);
        }
        System.out.println("From Collections.frequency : " + frequencyMap);
    }

    private static void frequencyWithMap_Old(List<Integer> list) {
        //Old way of doing
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Integer i : list) {
            //freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
            if (freqMap.containsKey(i))
                freqMap.put(i, freqMap.get(i) + 1);
            else
                freqMap.put(i, 1);
        }
        System.out.println(freqMap);
    }
}