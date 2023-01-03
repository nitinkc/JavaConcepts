package nitin.streams.collectors.c8minMaxAvgCount;

import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class M2CollectingMaxMin {
    public static void main(String[] args) {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //find the name of the employee with max Salary
        String maxSalEmp = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(EmployeeSimple::getSalary)),//Collector as the first argument//First argument to find the max
                                emp -> emp.map(EmployeeSimple::getName)//Mapping Function as the second argument
                                        .orElse("No Name")//maxBy returns an optional so use orElse for
                        )
                );
        employees.stream().forEach(System.out::println);
        System.out.println(maxSalEmp);

        //TODO: Find the map of names with max Salary
    }
}
