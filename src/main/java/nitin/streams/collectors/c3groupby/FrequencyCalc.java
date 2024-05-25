package nitin.streams.collectors.c3groupby;

import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class FrequencyCalc {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 3, 4, 5, 6, 7, 8, 6, 5, 4, 3, 2, 1);

        Function<List<Integer>, List<Integer>> numbers = Function.identity(); //returns function that always returns its input argument
        List<Integer> distinct = list.stream().distinct().collect(Collectors.toList());

        List<Integer> inputNumbers = numbers.apply(list);
        System.out.println(inputNumbers);
        System.out.println(distinct);

        Map<Integer, Long> freqMap = list
                .stream()
                .collect(groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freqMap);

        List<EmployeeSimple> empSimple = SampleData.getSimpleEmployees();

        Predicate<EmployeeSimple> ageNotNull = emp -> null != emp.getAge();
        Predicate<EmployeeSimple> salaryNotNull = emp -> null != emp.getSalary();

        Map<Integer, Set<Integer>> expByAge = empSimple
                .stream()
                .filter(ageNotNull)
                .filter(salaryNotNull)
                .collect(groupingBy(EmployeeSimple::getAge, mapping(EmployeeSimple::getExperience, toSet())));
        System.out.println("experience by age" + expByAge);

        freqWithCollectionsFrequency(list);

        frequencyWithGetOrDefault(list);

        frequencyWithMap_Old(list);
    }

    private static void frequencyWithGetOrDefault(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer x : list) {
            map.put(x, map.getOrDefault(x, 0) + 1);//default to 0 and adding 1
        }
        System.out.println(map);
    }

    private static void freqWithCollectionsFrequency(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for (int i : set) {
            int frequency = Collections.frequency(list, i);
            System.out.println(i + " : " + frequency);
        }
    }

    private static void frequencyWithMap_Old(List<Integer> list) {
        //Old way of doing same thing
        Map<Integer, Integer> map2 = new HashMap<>();
        for (Integer x : list) {
            if (map2.containsKey(x)) {
                map2.put(x, map2.get(x) + 1);
            } else {
                map2.put(x, 1);
            }
        }
        System.out.println(map2);
    }
}
