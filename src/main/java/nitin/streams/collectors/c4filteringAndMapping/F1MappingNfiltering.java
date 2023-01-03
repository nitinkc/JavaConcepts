package nitin.streams.collectors.c4filteringAndMapping;

import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class F1MappingNfiltering {
    public static void main(String[] args) {
        //map -> Streams -> transforms from one style to another
        //mapping -> transforming in the middle of a reduce

        //filter -> Streams, filtering -> reduce operation, collect

        //map -> Streams, mapping -> transforming in the middle of a reduce
        //filter -> Streams. filtering ->

        List<Integer> list = getEvenNumberList();

        //Find frequency of all the numbers
        Map<Integer,Long> map = list.stream()
                //.collect(groupingBy(element -> element, counting()));// Function.identity() Equivalent to an i in a for loop
                .collect(Collectors.groupingBy(Function.identity(), counting()));//collect takes a COLLECTOR as parameter. any method that returns a collector can be used

        System.out.println(map);//{1=3, 2=2, 3=3, 4=2, 5=2, 6=2, 7=1, 8=1}

        //return a map (age : names as value) with names greater than 4 characters.
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //mapListObject(employees);
        listAge_Name_UsingMapping(employees);
        setAge_Name_usingMapping(employees);

        listAge_Name_UsingMapping_withFilter(employees);

        //Teeing -> Java 12 -  to combine 2 collectors together
        //groupingBy and mapping (apply a Function, and then Collector as a second argument)
        //collectingAndThen      (Collection, then use a Function as a second argument)
        //teeing(Collector, Collector, operation)
    }

    private static List<Integer> getEvenNumberList() {
        List<Integer> list = List.of(1,2,1,3,3,4,5,6,7,8,6,5,4,3,2,1);
        List<Integer> evenNumberList = list.stream()
                .collect(filtering(number -> number % 2 == 0, toList()));
        System.out.println(evenNumberList);//[2, 4, 6, 8, 6, 4, 2]
        return list;
    }

    private static void listAge_Name_UsingMapping_withFilter(List<EmployeeSimple> employees) {
        Map<Integer, Set<String>> collect3 = employees
                .parallelStream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(groupingBy(EmployeeSimple::getAge,
                                mapping(EmployeeSimple::getName,
                                        filtering(name -> name.length() < 4,
                                                flatMapping(name -> List.of(name, name.toUpperCase(), name.toLowerCase()).stream(), toSet())
                                        )
                                )
                        )
                );
        System.out.println(collect3);

    }

    private static void setAge_Name_usingMapping(List<EmployeeSimple> employees) {
        Map<Integer, List<String>> collect3 = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge())
                .collect(groupingBy(EmployeeSimple::getAge, mapping(e -> e.getName(), toList())));
        System.out.println(collect3);
    }

    private static void listAge_Name_UsingMapping(List<EmployeeSimple> employees) {
        Map<Integer, Set<String>> collect = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge())
                .collect(groupingBy(EmployeeSimple::getAge, mapping(e -> e.getName(), Collectors.toSet())));
        System.out.println(collect);
    }

    private static void mapListObject(List<EmployeeSimple> employees) {
        Map<Integer, List<EmployeeSimple>> collect1 = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge())
                .collect(groupingBy(EmployeeSimple::getAge));
        System.out.println(collect1);
    }
}
