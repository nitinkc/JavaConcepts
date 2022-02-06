package nitin.streams.sortingNcomparators;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

/**
 * @author Created by nichaurasia
 * Created on Monday, September/28/2020 at 12:07 AM
 */

public class EmployeeServices {
    public static void main(String[] args) {
        final List<Employee> list = Arrays.asList(
                new Employee("John", 20, 65000, 'C', 5),
                new Employee("Wayne", 20, 65430, 'C', 4),
                new Employee("Dow", 30, 74445, 'B', 6),
                new Employee("Jane", 35, 76546, 'B', 5),
                new Employee("Don", 35, 90000, 'A', 10)
        );

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

    private static void incrementSalary(List<Employee> list) {
        list.stream()
                .filter(x -> x.getLevel() == 'C')
                .map(x -> x.getSalary() + (x.getSalary() / 10))
                .forEach(System.out::println);
    }

    private static void anyMatchageGT30Employee(List<Employee> list) {
        System.out.println(list.stream()
                //.distinctBy()
                .anyMatch(Lambdas.ageGT30Predicate));
    }

    private static void avgSalariesSum(List<Employee> list) {
        OptionalDouble avgSalOptional = list.stream()
                .mapToDouble(Employee::getSalary)
                .average();

        avgSalOptional
                .ifPresent(System.out::println);
    }

    private static void avgSalariesreduce(List<Employee> list) {
        System.out.println(list.stream()
                .map((e) -> e.getSalary())
                .reduce(0.0, (x, y) -> (x + y)));
    }

    private static void howManyGT30Employee(List<Employee> list) {

        System.out.println(list.stream()
                .filter(Lambdas.ageGT30Predicate)
                .count());
    }
}
