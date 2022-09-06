package nitin.streams.sortingNcomparators;

import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.util.List;
import java.util.OptionalDouble;

/**
 * @author Created by nichaurasia
 * Created on Monday, September/28/2020 at 12:07 AM
 */

public class EmployeeServices {
    public static void main(String[] args) {
        final List<EmployeeSimple> list = SampleData.getSimpleEmployees();

        System.out.println("Increment Salary by 10% if level C, 15% if level B and 20% if A");
        incrementSalary(list);
        System.out.println();

        System.out.println("Any Match ageGT30Predicate");
        anyMatchageGT30Employee(list);

        System.out.println("how many ageGT30");
        howManyGT30Employee(list);

        System.out.println("Average of salaries");
        avgSalariesSum(list);

        //TODO :
        System.out.println("Average of salaries");
        avgSalariesreduce(list);


    }

    private static void incrementSalary(List<EmployeeSimple> list) {
        list.stream()
                .filter(x -> x.getLevel() == 'C')
                .map(x -> x.getSalary() + (x.getSalary() / 10))
                .forEach(System.out::println);
    }

    private static void anyMatchageGT30Employee(List<EmployeeSimple> list) {
        System.out.println(list.stream()
                //.distinctBy()
                .anyMatch(Lambdas.ageGT30Predicate));
    }

    private static void avgSalariesSum(List<EmployeeSimple> list) {
        OptionalDouble avgSalOptional = list.stream()
                .mapToDouble(EmployeeSimple::getSalary)
                .average();

        avgSalOptional
                .ifPresent(System.out::println);
    }

    private static void avgSalariesreduce(List<EmployeeSimple> list) {
        System.out.println(list.stream()
                .map((e) -> e.getSalary())
                .reduce(0.0, (x, y) -> (x + y)));
    }

    private static void howManyGT30Employee(List<EmployeeSimple> list) {

        System.out.println(list.stream()
                .filter(Lambdas.ageGT30Predicate)
                .count());
    }
}
