package nitin.streams.collectors.c2partitioning;


import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

public class Intro {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,1,3,3,4,5,6,7,8,6,5,4,3,2,1);
        Map<Boolean, List<Integer>> collect = list.stream()
                .collect(partitioningBy(number -> number % 2 == 0));
        System.out.println(collect);//{false=[1, 1, 3, 3, 5, 7, 5, 3, 1], true=[2, 4, 6, 8, 6, 4, 2]}


        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();//Call from DB

        //Split the list into 2 sub list based on even and odd age
        splitEmpList(employees);

        doNotDo(employees);
    }

    private static void splitEmpList(List<EmployeeSimple> employees) {
        Predicate<EmployeeSimple> evenAgedEmpPredicate = emp -> emp.getAge() % 2 == 0;

        Map<Boolean, List<EmployeeSimple>> listMap = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge())
                .filter(emp -> null != emp.getAge())
                //.collect(partitioningBy(x -> evenAgedEmpPredicate.test(x)));
                .collect(partitioningBy(evenAgedEmpPredicate));//⌘Cmd ⌥Opt V	Declare the variable


        System.out.println(listMap);
    }

    private static void doNotDo(List<EmployeeSimple> employees) {
        List<EmployeeSimple> evenAgedEmp = employees.stream()
                .filter(Objects::isNull).filter(emp -> null != emp.getAge())
                .filter(employee -> employee.getAge() % 2 == 0)
                .collect(Collectors.toList());

        List<EmployeeSimple> oddAgedEmp = employees.stream()
                .filter(Objects::isNull).filter(emp -> null != emp.getAge())
                .filter(employee -> employee.getAge() % 2 != 0)
                .collect(Collectors.toList());
    }
}
