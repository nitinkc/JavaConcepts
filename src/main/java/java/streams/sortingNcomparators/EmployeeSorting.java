package java.streams.sortingNcomparators;

import java.streams.sortingNcomparators.data.EmployeeData;

import java.util.List;

/**
 * Created by nichaurasia on Thursday, February/13/2020 at 11:50 AM
 */

public class EmployeeSorting {
    public static void main(String[] args) {
        final List<Employee> list = EmployeeData.createEmployee();

        System.out.println("Sorting with ageDifference method");
        //sortAgeByAgeDiffMethod(list);
        System.out.println();

        System.out.println("Sorting with stream sorted (Comparator.comparing)");
        //sortUsingAgeLambda(list);

        System.out.println("Reverse Sorting with stream sorted (Comparator.comparing)");
        reverseSortUsingAgeLambda(list);

        System.out.println("Reverse Sorting with age and if age is same, sort by salary sorted (Comparator.comparing)");
        reverseSortUsingAgeNSalaryLambda(list);

        System.out.println("Employee with max age");
        //maxAgeEmployee(list);

        System.out.println("Employee with max salary");
        maxSalaryEmployee(list);

        System.out.println("Employee with min salary");
        minSalaryEmployee(list);

        System.out.println("Employee with min salary");
        minSalaryEmployee(list);

        System.out.println("Employee with distinct age");
        // TODO :: find the way
        distinctAgeEmployee(list);
    }

    private static void distinctAgeEmployee(List<Employee> list) {
        list.stream()
                .filter(x -> x.getAge() > 0)
                .distinct()
                .forEach(System.out::println);
    }

    private static void minSalaryEmployee(List<Employee> list) {
        System.out.println(list.stream()
                .min(Lambdas.salaryLambda)
                .get());
    }

    private static void maxSalaryEmployee(List<Employee> list) {
        System.out.println(list.stream()
                .max(Lambdas.salaryLambda)
                .get());
    }

    private static void reverseSortUsingAgeNSalaryLambda(List<Employee> list) {
        list
                .stream()
                .sorted(Lambdas.revAgeLambda
                .thenComparing(Lambdas.salaryLambda))
                .forEach(System.out::println);
    }

    private static void reverseSortUsingAgeLambda(List<Employee> list) {
        list.stream()
                .sorted(Lambdas.revAgeLambda)
                .forEach(System.out::println);
    }

    private static void maxAgeEmployee(List<Employee> list) {
        Employee e = list.stream()
                .max(Lambdas.ageLambda)
                .get();
        System.out.println(e);
    }

    private static void sortUsingAgeLambda(List<Employee> list) {
        list.stream()
                .sorted(Lambdas.ageLambda)
                .forEach(System.out::println);
    }

    private static void sortAgeByAgeDiffMethod(List<Employee> list) {
        list.stream()
                .sorted(Lambdas.ageLambda)
               .forEach(System.out::println);
    }
}
