package com.nitin.zJava8Revisions.sortingNcomparators;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nichaurasia on Thursday, February/13/2020 at 11:50 AM
 */

public class EmployeeSorting {
    public static void main(String[] args) {
        final List<Employee> list = Arrays.asList(
                new Employee("John",20,65000, 'C', 5),
                new Employee("Wayne", 20,65430, 'C', 4),
                new Employee("Dow", 30,74445,'B',6),
                new Employee("Jane", 35,76546,'B',5),
                new Employee("Don", 35,90000,'A',10)
        );

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

    private static void avgSalariesSum(List<Employee> list) {
        OptionalDouble avgSalOptional= list.stream()
                .mapToDouble(Employee::getSalary)
                .average();

       avgSalOptional
               .ifPresent(System.out::println);
    }

    private static void avgSalariesreduce(List<Employee> list) {
        System.out.println(list.stream()
               // .map((e) -> e.getSalary())
             //.ma
                .reduce(0.0, (x,y) -> (x+y)/2));
    }

    private static void howManyGT30Employee(List<Employee> list) {

        System.out.println(list.stream()
                .filter(Lambdas.ageGT30Predicate)
                .count());
    }

    private static void distinctAgeEmployee(List<Employee> list) {
        list.stream()
                .filter(x -> x.getAge() > 0)
                .distinct()
                .forEach(System.out::println);
    }


    private static void anyMatchageGT30Employee(List<Employee> list) {
        System.out.println(list.stream()
                //.distinctBy()
                .anyMatch(Lambdas.ageGT30Predicate));
    }

    private static void minSalaryEmployee(List<Employee> list) {
        System.out.println(list.stream()
                .min((e1,  e2) -> e1.getAge() - e2.getAge();)
                //.get());
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
