package java.streams.t2Streams.t2Streams.streams2.streams;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
