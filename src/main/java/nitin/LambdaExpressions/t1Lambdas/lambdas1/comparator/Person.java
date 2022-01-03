package nitin.LambdaExpressions.t1Lambdas.lambdas1.comparator;
/** Represents a person's given name 
 *  and family name. From the 2nd OOP lecture.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, 
 *  servlets, JSP, and Java 7 and Java 8 programming</a>.
 */
public class Person {
  private String firstName, lastName;
  
  public Person(String firstName,
                String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
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
  
  /** Prints person as "PERSON: [first] [last]". 
   *  The toString method is briefly covered in the 
   *  "Advanced topics" section at end of the 2nd OOP lecture,
   *  but the idea is that it is called automatically when
   *  you print a Person object.
   */
  @Override
  public String toString() {
    return("PERSON: " + getFullName());
  }
}
