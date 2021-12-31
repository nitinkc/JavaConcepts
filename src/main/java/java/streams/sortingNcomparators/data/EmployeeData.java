package java.streams.sortingNcomparators.data;

import java.streams.sortingNcomparators.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Created by nichaurasia
 * @create on Tuesday, September/29/2020 at 6:55 PM
 */

public class EmployeeData {
    public static List<Employee> createEmployee(){
        return Arrays.asList(
                new Employee("John",20,65000, 'C', 5),
                new Employee("Wayne", 20,65430, 'C', 4),
                new Employee("Dow", 30,74445,'B',6),
                new Employee("Jane", 35,76546,'B',5),
                new Employee("Don", 35,90000,'A',10)
        );
    }

    private EmployeeData(){}
}
