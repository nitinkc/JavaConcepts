package nitin.streams.collectors.c3groupby;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

import com.entity.EmployeeSimple;
import com.entity.SampleData;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class C3GroupBy {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 1, 3, 3, 4, 5, 6, 7, 8, 6, 5, 4, 3, 2, 1);
        Function<List<Integer>, List<Integer>> numbers =
                Function.identity(); // returns function that always returns its input argument
        List<Integer> inputNumbers = numbers.apply(list);
        System.out.println(inputNumbers);

        groupStringsBySize();
        findFrequencyOfRepeatedNumbers();
        empGroupByName(); // Group By Name
        ageByName();
        countByName(); // Name and its count (frequency
        countIntByName(); // Name and its count (frequency)- collectingAndThen
        groupByAge();
    }

    private static void groupStringsBySize() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        // The Map will have the lengths as keys and lists of strings with those lengths as values
        Map<Integer, List<String>> categorizedByLength =
                strings.stream()
                        // .collect(Collectors.groupingBy(str -> str.length(),
                        // Collectors.toList()));//Two-Argument groupingBy: Uses the classifier
                        // function and a specified downstream collector to determine how the
                        // grouped elements are collected.
                        .collect(
                                Collectors.groupingBy(
                                        String::length)); // Single-Argument groupingBy: Uses the
        // classifier function and defaults to
        // collecting elements into a List.
        System.out.println(categorizedByLength); // {4=[date], 5=[apple], 6=[banana, cherry]}
    }

    private static void findFrequencyOfRepeatedNumbers() {
        List<Integer> list = getEvenNumberList();

        // Find frequency of all the numbers
        Map<Integer, Long> map =
                list.stream()
                        // .collect(groupingBy(element -> element, counting()));//
                        // Function.identity() Equivalent to an i in a for loop
                        .collect(
                                groupingBy(
                                        identity(),
                                        counting())); // collect takes a COLLECTOR as parameter(with
        // single argument overloaded method). any
        // method that returns a collector can be used

        System.out.println(map); // {1=3, 2=2, 3=3, 4=2, 5=2, 6=2, 7=1, 8=1}
    }

    private static void empGroupByName() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        Map<String, List<EmployeeSimple>> byName =
                employees.stream()
                        .filter(Objects::nonNull)
                        .filter(emp -> null != emp.getName())
                        // .collect(Collectors.groupingBy(emp -> emp.getName()));
                        .collect(
                                groupingBy(
                                        EmployeeSimple
                                                ::getName)); // Grouping By -> Taking function as a
        // parameter
        System.out.println("By Name :: " + byName);
    }

    private static void ageByName() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //        Map<String, List<Integer>> byName = employees.stream()
        //                .map(emp -> emp.getAge())//Lost it... from Stream of Emp it becomes Stream
        // of String. Age is lost

        Map<String, List<Integer>> byName =
                employees.stream()
                        .filter(Objects::nonNull)
                        .filter(emp -> null != emp.getName())
                        .filter(emp -> null != emp.getAge())
                        .collect(
                                groupingBy(
                                        EmployeeSimple::getName,
                                        Collectors.mapping(
                                                EmployeeSimple::getAge,
                                                Collectors.toList()))); // Grouping By Overloaded ->
        // Taking function as a
        // parameter and another
        // collector

        // Recursive Structure
        // Collector(Function, Collector(Function, Collector))
        System.out.println("Age By Name :: " + byName);
        Map<String, Set<Integer>> byNameSet =
                employees.stream()
                        .filter(Objects::nonNull)
                        .filter(emp -> null != emp.getName())
                        .filter(emp -> null != emp.getAge())
                        .collect(
                                groupingBy(
                                        EmployeeSimple::getName,
                                        Collectors.mapping(
                                                EmployeeSimple::getAge,
                                                Collectors.toSet()))); // Grouping By Overloaded ->
        // Taking function as a
        // parameter and another
        // collector

        // Recursive Structure
        // Collector(Function, Collector(Function, Collector))
        System.out.println("Age By Name (Set):: " + byNameSet);
    }

    private static void countByName() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        Map<String, Long> byName =
                employees.stream()
                        .filter(Objects::nonNull)
                        .filter(emp -> null != emp.getName())
                        .filter(emp -> null != emp.getAge())
                        .collect(
                                groupingBy(
                                        EmployeeSimple::getName,
                                        counting())); // Grouping By Overloaded -> Taking function
        // as a parameter and another collector

        System.out.println("Count By Name : " + byName);
    }

    private static void countIntByName() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        // groupingBy and mapping (apply a Function, and then Collector as a second argument)
        // collectingAndThen      (Collection, then use a Function as a second argument)
        Map<String, Integer> byName =
                employees.stream()
                        .filter(Objects::nonNull)
                        .filter(emp -> null != emp.getName())
                        .filter(emp -> null != emp.getAge())
                        // .collect(groupingBy(EmployeeSimple::getName,
                        // collectingAndThen(counting(), value -> value.intValue())));
                        .collect(
                                groupingBy(
                                        EmployeeSimple::getName,
                                        collectingAndThen(
                                                counting(),
                                                Long::intValue))); // Perform a transformation
        // and then keep in the
        // bucket

        System.out.println("Name and its count (frequency) : " + byName);
    }

    private static List<Integer> getEvenNumberList() {
        List<Integer> list = List.of(1, 2, 1, 3, 3, 4, 5, 6, 7, 8, 6, 5, 4, 3, 2, 1);
        List<Integer> evenNumberList =
                list.stream().collect(filtering(number -> number % 2 == 0, toList()));
        // System.out.println(evenNumberList);//[2, 4, 6, 8, 6, 4, 2]
        return list;
    }

    private static void groupByAge() {
        List<EmployeeSimple> empSimple = SampleData.getSimpleEmployees();

        Predicate<EmployeeSimple> ageNotNull = emp -> null != emp.getAge();
        Predicate<EmployeeSimple> salaryNotNull = emp -> null != emp.getSalary();

        Map<Integer, Set<Integer>> expByAge =
                empSimple.stream()
                        .filter(ageNotNull)
                        .filter(salaryNotNull)
                        .collect(
                                groupingBy(
                                        EmployeeSimple::getAge,
                                        mapping(EmployeeSimple::getExperience, toSet())));
        System.out.println("experience by age" + expByAge);
    }
}
