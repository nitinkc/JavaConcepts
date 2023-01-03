package nitin.streams.collectors.c3groupby;

import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class C3GroupBy {
    public static void main(String[] args) {
        empGroupByName();
        ageByName();
        countByName();//counting
        countIntByName();
    }

    private static void empGroupByName() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        Map<String, List<EmployeeSimple>> byName = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getName())
                //.collect(Collectors.groupingBy(emp -> emp.getName()));
                .collect(groupingBy(EmployeeSimple::getName));//Grouping By -> Taking function as a parameter
        System.out.println("By Name :: "+byName);
    }

    private static void ageByName() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

//        Map<String, List<Integer>> byName = employees.stream()
//                .map(emp -> emp.getAge())//Lost it... from Stream of Emp it becomes Stream of String. Age is lost

        Map<String, List<Integer>> byName = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getName()).filter(emp -> null != emp.getAge())
                .collect(groupingBy(EmployeeSimple::getName,
                        Collectors.mapping(EmployeeSimple::getAge, Collectors.toList())));//Grouping By Overloaded -> Taking function as a parameter and another collector

        //Recursive Structure
        //Collector(Function, Collector(Function, Collector))
        System.out.println(byName);

        Map<String, Set<Integer>> byNameSet = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getName()).filter(emp -> null != emp.getAge())
                .collect(
                        groupingBy(EmployeeSimple::getName,
                                Collectors.mapping(EmployeeSimple::getAge, Collectors.toSet())));//Grouping By Overloaded -> Taking function as a parameter and another collector

        //Recursive Structure
        //Collector(Function, Collector(Function, Collector))
        System.out.println(byNameSet);
    }

    private static void countByName() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        Map<String, Long> byName = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getName()).filter(emp -> null != emp.getAge())
                .collect(groupingBy(EmployeeSimple::getName, counting()));//Grouping By Overloaded -> Taking function as a parameter and another collector

        System.out.println(byName);
    }

    private static void countIntByName() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //groupingBy and mapping (apply a Function, and then Collector as a second argument)
        //collectingAndThen      (Collection, then use a Function as a second argument)
        Map<String, Integer> byName = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getName()).filter(emp -> null != emp.getAge())
                //.collect(groupingBy(EmployeeSimple::getName, collectingAndThen(counting(), value -> value.intValue())));
                .collect(groupingBy(EmployeeSimple::getName, collectingAndThen(counting(), Long::intValue)));//Perform a transformation and then keep in the bucket

        System.out.println(byName);
    }
}
