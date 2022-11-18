package nitin.streams.variousMethodsOfStreams.collectors.groupBy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCalc {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,1,3,3,4,5,6,7,8,6,5,4,3,2,1);

        Map<Integer, Long> freqMap = list
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(freqMap);

        Map<Integer,Integer> map = new HashMap<>();
        for (Integer x : list){
            map.put(x, map.getOrDefault(x,0) + 1);//default to 0 and adding 1
        }
        System.out.println(map);
    }
}
