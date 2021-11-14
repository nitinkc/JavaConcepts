package com.nitin.zCoreServletsTraining.t2Streams.streams3.streams;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SalaryMin {
  private static List<Employee> googlers = EmployeeSamples.getGooglers();
  
  public static int min1() {
    return googlers.stream()
                   .mapToInt(Employee::getSalary)
                   .min()
                   .orElse(Integer.MAX_VALUE);
  }
  
  public static int min2() {
    return googlers.stream()
                   .map(Employee::getSalary)
                   .min((n1, n2) -> n1 - n2)
                   .orElse(Integer.MAX_VALUE);
  }
  
  public static int min3() {
    return googlers.stream()
                   .map(Employee::getSalary)
                   .reduce(Integer.MAX_VALUE, Integer::min);

  }
  
  @Test
  public void testMins() {
    assertThat(min1(), is(equalTo(min2())));
    assertThat(min1(), is(equalTo(min3())));
  }
}
