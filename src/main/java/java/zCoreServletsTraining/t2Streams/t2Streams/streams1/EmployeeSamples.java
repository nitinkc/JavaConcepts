package java.zCoreServletsTraining.t2Streams.t2Streams.streams1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeSamples {
  private static final List<Employee> SAMPLE_EMPLOYEES = 
    Arrays.asList(
      new Employee("Harry", "Hacker", 1, 234_567),
      new Employee("Polly", "Programmer", 2, 333_333),
      new Employee("Cody", "Coder", 8, 199_999), 
      new Employee("Devon", "Developer", 11, 175_000),
      new Employee("Desiree", "Designer", 14, 212_000),
      new Employee("Archie", "Architect", 16, 144_444),
      new Employee("Tammy", "Tester", 19, 166_777),
      new Employee("Sammy", "Sales", 21, 45_000),
      new Employee("Larry", "Lawyer", 22, 33_000),
      new Employee("Amy", "Accountant", 25, 85_000) );
  
  public static List<Employee> getSampleEmployees() {
    return(SAMPLE_EMPLOYEES);
  }
  
  private static List<Employee> GOOGLERS = 
    Arrays.asList(
      new Employee("Larry", "Page", 1, 9_999_999),
      new Employee("Sergey", "Brin", 2, 8_888_888),
      new Employee("Eric", "Schmidt", 3, 7_777_777),
      new Employee("Nikesh", "Arora", 4, 6_666_666),
      new Employee("David", "Drummond", 5, 5_555_555),
      new Employee("Patrick", "Pichette", 6, 4_444_444),
      new Employee("Susan", "Wojcicki", 7, 3_333_333),
      new Employee("Peter", "Norvig", 8, 900_000),
      new Employee("Jeffrey", "Dean", 9, 800_000),
      new Employee("Sanjay", "Ghemawat", 10, 700_000),
      new Employee("Gilad", "Bracha", 11, 600_000) );
  
  public static List<Employee> getGooglers() {
    return(GOOGLERS);
  } 
  
  private static Map<Integer,Employee> googleMap = new HashMap<>();
  
  static {
    GOOGLERS.stream().forEach(e -> googleMap.put(e.getEmployeeId(), e));
  }
  
  public static Employee findGoogler(Integer employeeId) {
    // Turn on print statement to verify lazy evaluation in "combinedExamples" of StreamSamples
    //System.out.println("Called findGooglers with id=" + employeeId);
    return(googleMap.get(employeeId));
  }
  
  private EmployeeSamples() {} // Uninstantiatable class
}
