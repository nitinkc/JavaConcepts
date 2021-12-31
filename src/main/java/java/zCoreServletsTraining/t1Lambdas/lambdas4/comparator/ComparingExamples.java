package java.zCoreServletsTraining.t1Lambdas.lambdas4.comparator;

import java.zCoreServletsTraining.t1Lambdas.lambdas4.function.Employee;

import java.util.Arrays;
import java.util.Comparator;


public class ComparingExamples {
  private static Employee[] employees = { new Employee("John", "Doe", 1, 234_567),
                                          new Employee("Jane", "Doe", 2, 333_333),
                                          new Employee("Sammy", "Smith", 3, 99_000),
                                          new Employee("Sally", "Smith", 4, 99_000) };
  private static String[] words = 
    { "hi", "hello", "hola", "bye", "goodbye", "adios" };

  public static void main(String[] args) {
    System.out.printf("Words before sorting: %s.%n", Arrays.asList(words));
    Arrays.sort(words, Comparator.comparing(String::length));
    System.out.printf("After sorting by length: %s.%n", Arrays.asList(words));
    Arrays.sort(words, Comparator.comparing(String::length).reversed());
    System.out.printf("After sorting by length (reversed): %s.%n", Arrays.asList(words));
    System.out.printf("Employees before sorting: %s.%n", Arrays.asList(employees));
    Arrays.sort(employees, Comparator.comparing(Employee::getLastName));
    System.out.printf("After sorting by last name: %s.%n", Arrays.asList(employees));
    Arrays.sort(employees, Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName));
    System.out.printf("After sorting by last name and then first name: %s.%n", Arrays.asList(employees));
    Arrays.sort(employees, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getEmployeeId));
    System.out.printf("After sorting by salary and then ID: %s.%n", Arrays.asList(employees));
  }
}
