package java.LambdaExpressions.t1Lambdas.lambdas3.function;

/** Represents a person that works at a company.
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
