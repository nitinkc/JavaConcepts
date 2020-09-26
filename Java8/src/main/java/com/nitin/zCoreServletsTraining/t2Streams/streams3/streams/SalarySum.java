package com.nitin.zCoreServletsTraining.t2Streams.streams3.streams;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/** Different ways to sum the salaries of a List of Employees. */

public class SalarySum {
  private static List<Employee> googlers = EmployeeSamples.getGooglers();
  
  public static int sum1() {
    return googlers.stream()
                   .mapToInt(Employee::getSalary)
                   .sum();
  }
  
  public static int sum2() {
    return googlers.stream()
                   .map(Employee::getSalary)
                   .reduce(0, Integer::sum);
  }
  
  @Test
  public void testSums() {
    assertThat(sum1(), is(equalTo(sum2())));
  }
}
