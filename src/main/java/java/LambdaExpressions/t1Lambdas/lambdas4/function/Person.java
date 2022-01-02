package java.LambdaExpressions.t1Lambdas.lambdas4.function;

/** A class that represents a person's given name 
 *  and family name. 
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */
public class Person {
  protected String firstName, lastName;
  
  public Person(String firstName,
                String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public Person() {
    this.firstName = PersonUtils.randomFirstName();
    this.lastName = PersonUtils.randomLastName();
  }
  
  /** The person's given (first) name. */
  
  public String getFirstName() {
    return (firstName);
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /** The person's family name (i.e., 
   *  last name or surname). 
   */
  public String getLastName() {
    return (lastName);
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  /** The person's given name and family name, printed
   *  in American style, with given name first and
   *  a space in between.
   */
  public String getFullName() {
    return(firstName + " " + lastName);
  }
  
  /** Returns a number in the form of the Comparator "compare" method,
   *  indicating which is considered less. This is a method
   *  reference that can be used with the sorted, min, or max
   *  methods of Stream. It could also be used with Arrays.sort.
   */
  public int firstNameComparer(Person other) {
    System.out.println("Comparing first names");
    return(firstName.compareTo(other.getFirstName()));
  }
  
  /** Returns a string such as "Bill Gates (Employer)" or
   *  "Ernest Hemingway (Writer)". It assumes there will be several
   *  meaningfully-named Person subclasses.
   */
  @Override
  public String toString() {
    return(String.format("%s (%s)", getFullName(), 
                         getClass().getSimpleName()));
  }
}
