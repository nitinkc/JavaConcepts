package nitin.streams.collectors.c8minMaxAvgCount;

import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class M1maxMin {
    public static void main(String[] args) {

        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //Find employee with Max Age using Streams
        minMaxIntro(employees);

        //Find maxBy minBy via Collectors
        minByMaxByIntro(employees);

        minAndMax(employees);

        minByAndMaxBy(employees);

    }
    private static void minByMaxByIntro(List<EmployeeSimple> employees) {
        EmployeeSimple collect = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(Collectors.maxBy(
                        Comparator.comparing(EmployeeSimple::getAge)))
                .orElse(new EmployeeSimple());

        System.out.println(collect.getAge());

        int minAge;//TODO: find way to utilize optional
        Integer minSalary = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .collect(Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(EmployeeSimple::getAge)),
                                emp -> emp.map(EmployeeSimple::getAge).orElseThrow()
                        )
                );
    }

    private static void minMaxIntro(List<EmployeeSimple> employees) {
        int maxAge = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .mapToInt(EmployeeSimple::getAge)
                .max().orElse(-1);
        System.out.println(maxAge);

        int minAge = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .map(EmployeeSimple::getAge)
                .min(Comparator.comparing(Integer::intValue))//Obvious comparing
                .orElse(-1);
        System.out.println(minAge);
    }

    private static void minAndMax(List<EmployeeSimple> employees) {

        // Max and Min return Optional Integer
        OptionalInt max = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getName()).filter(emp -> null != emp.getAge())
                .mapToInt(EmployeeSimple::getAge)
                .max();
        System.out.println(max.getAsInt());
    }

    private static void minByAndMaxBy(List<EmployeeSimple> employees) {
        // MaxBy and MinBy return Optional of the Object
        EmployeeSimple maxBy = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getName()).filter(emp -> null != emp.getAge())
                .collect(Collectors.maxBy(
                        Comparator.comparing(
                                EmployeeSimple::getAge))).orElse(new EmployeeSimple());
        System.out.println(maxBy);//EmployeeSimple(name=Jane, age=35, salary=76546.0, level=B, experience=5)

        EmployeeSimple minBy = employees.stream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getName()).filter(emp -> null != emp.getAge())
                .collect(Collectors.minBy(Comparator.comparing(EmployeeSimple::getAge))).orElse(new EmployeeSimple());
        System.out.println(minBy);//EmployeeSimple(name=John, age=20, salary=65000.0, level=C, experience=5)
    }
}
