package nitin.streams.collectors.c4filteringAndMapping;

import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class F1MappingNfiltering {
    public static void main(String[] args) {
        tests();
    }

    private static void tests() {
        //return a map (age : names as value) with names greater than 4 characters.
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //mapListObject(employees);
        listAge_Name_UsingMapping(employees);
        setAge_Name_usingMapping(employees);

        listAge_Name_UsingMapping_withFilter(employees);
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
                .filter(Objects::nonNull)
                .filter(emp -> null != emp.getAge())
                .collect(groupingBy(EmployeeSimple::getAge));
        System.out.println(collect1);
    }
}
