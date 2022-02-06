package nitin.generic.oReilly.a5map;


import nitin.generic.oReilly.a3Max.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class MapEmployees {
    public static void main(String[] args) {
        List<Employee> employees = createEmployees();
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(toList());

        List<Integer> ids = employees.stream()
                .map(Employee::getId)
                .collect(toList());

        int totalLength = employees.stream()
                .map(Employee::getName)
                .mapToInt(String::length)//mapToInt has additional methods that can only be applied to integers, like sum, average etc
                .sum();

        // Add employees to a map using id as key
        Map<Integer, Employee> employeeMap = employees.stream()
                .collect(toMap(Employee::getId, Function.identity()));// Function.identity() means e -> e

        employeeMap.forEach((id, emp) -> System.out.println(id + ": " + emp));

        // Sort employees by id and print them
        System.out.println("Sorted by key:");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });

        // Reverse sort employees by id and print them
        System.out.println("Reverse sorted by key:");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });

        // Sort employees by name and print them
        System.out.println("Sorted by name:");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparing(Employee::getName)))
                // .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });
    }

    public static List<Employee> createEmployees() {
        return Arrays.asList(
                new Employee(1, "Haradanahalli Doddegowda Deve Gowda"),
                new Employee(2, "Avul Pakir Jainulabdeen Abdul Kalam"),
                new Employee(3, "Dr. Sarvepalli Radhakrishnan"),
                new Employee(4, "Kocheril Raman Narayanan")
        );
    }
}
