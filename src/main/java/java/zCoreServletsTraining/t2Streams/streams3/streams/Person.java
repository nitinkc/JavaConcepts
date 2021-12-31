package java.zCoreServletsTraining.t2Streams.streams3.streams;

/** A class that represents a person's given name 
 *  and family name. 
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
