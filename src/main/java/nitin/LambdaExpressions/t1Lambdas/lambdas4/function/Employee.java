package nitin.LambdaExpressions.t1Lambdas.lambdas4.function;

/** Represents a person that works at a company.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */
public class Employee extends Person {
  private int employeeId, salary;
  
  public Employee(String firstName, String lastName,
                  int employeeId, int salary) {
    super(firstName, lastName);
    this.employeeId = employeeId;
    this.salary = salary;
  }
  
  /** The ID of the employee, with the assumption that
   *  lower numbers are people that started working at
   *  the company earlier than those with higher ids.
   */
  public int getEmployeeId() {
    return (employeeId);
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  /** Yearly salary in US dollars. */
  
  public int getSalary() {
    return(salary);
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }
  
  @Override
  public String toString() {
    return(String.format("%s %s [Employee#%s $%,d]", 
           firstName, lastName, employeeId, salary));
  }
}
