package nitin.streams.collectors.c9reducing;

import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.util.List;
import java.util.Objects;

public class R1reduceIntro {
    public static void main(String[] args) {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //Find total sum of salaries of each employee
        sumWithReduce(employees);
        sumWithOutReduce(employees);
    }


    private static void sumWithOutReduce(List<EmployeeSimple> employees) {
        Double totalSalary =
                employees.stream()
                        .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                        .mapToDouble(EmployeeSimple::getSalary)
                        .average().orElseThrow();

        System.out.println(totalSalary);
    }

    //Reduce takes the form of - reduce, collect, sum

    private static void sumWithReduce(List<EmployeeSimple> employees) {
        Double totalSalary =
                employees.stream()
                        .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                        .map(EmployeeSimple::getSalary)
                        //.reduce(0, (total, age) -> total + age));
                        .reduce(0.0, Double::sum);
        //.orElse(-1D);

        //Reduce with identity returbs a <T>, reduce without identity returns a Optional<T>

        System.out.println(totalSalary);
    }
}
