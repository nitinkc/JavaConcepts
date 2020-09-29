package com.nitin.zJava8Revisions.sortingNcomparators;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Created by nichaurasia
 * @create on Monday, September/28/2020 at 12:07 AM
 */

public class EmployeeServices {
    public static void main(String[] args) {
        final List<Employee> list = Arrays.asList(
                new Employee("John",20,65000, 'C', 5),
                new Employee("Wayne", 20,65430, 'C', 4),
                new Employee("Dow", 30,74445,'B',6),
                new Employee("Jane", 35,76546,'B',5),
                new Employee("Don", 35,90000,'A',10)
        );

        System.out.println("Increment Salary by 10% if level C, 15% if level B abd 20% if A");
        incrementSalary(list);
        System.out.println();
    }

    private static void incrementSalary(List<Employee> list) {
        list.stream()
                .filter(x -> x.getLevel() == 'C')
                .map(x -> x.getSalary() + (x.getSalary()/10))
                .forEach(System.out::println);
    }
}
