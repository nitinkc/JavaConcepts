package java8.zCoreServletsTraining.t1Lambdas.lambdas3.function;
/*

import java.util.*;
import org.junit.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import static com.nitin.zCoreServletsTraining.t1Lambdas.lambdas3.function.EmployeeUtils.*;
import static com.nitin.zCoreServletsTraining.t1Lambdas.lambdas3.function.FunctionUtils.*;

*/
/** Testing the three versions of matching:
 *  1) Specific to Employee and the property (findEmployeeByFirstName, findEmployeeBySalary)
 *  2) Specific to Employee, with Predicate for the test (firstMatchingEmployee)
 *  2) Generically typed, with Predicate for the test (firstMatch)
 *//*

public class MatchTester {
  private static final List<Employee> EMPLOYEES = EmployeeSamples.getSampleEmployees();
  private static final String[] FIRST_NAMES = { "Archie", "Amy", "Andy" };
  private static final int[] SALARY_CUTOFFS = { 200_000, 300_000, 400_000 };
  
  @Test
  public void testNames() {
    assertThat(findEmployeeByFirstName(EMPLOYEES, FIRST_NAMES[0]), is(notNullValue()));
    for(String firstName: FIRST_NAMES) {
      Employee match1 = findEmployeeByFirstName(EMPLOYEES, firstName);
      Employee match2 = firstMatchingEmployee(EMPLOYEES, e -> e.getFirstName().equals(firstName));
      Employee match3 = firstMatch(EMPLOYEES, e -> e.getFirstName().equals(firstName));
      assertThat(match1, allOf(equalTo(match2), equalTo(match3)));
    }
  }
  
  @Test
  public void testSalaries() {
    assertThat(findEmployeeBySalary(EMPLOYEES, SALARY_CUTOFFS[0]), is(notNullValue()));
    for(int cutoff: SALARY_CUTOFFS) {
      Employee match1 = findEmployeeBySalary(EMPLOYEES, cutoff);
      Employee match2 = firstMatchingEmployee(EMPLOYEES, e -> e.getSalary() >= cutoff);
      Employee match3 = firstMatch(EMPLOYEES, e -> e.getSalary() >= cutoff);
      assertThat(match1, allOf(equalTo(match2), equalTo(match3)));
    }
  }
}
*/
