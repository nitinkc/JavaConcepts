package com.nitin.zCoreServletsTraining.t2Streams.streams1;

/** A simplified version of the Employee class.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class Emp {
  private String firstName, lastName, office;

  public Emp(String firstName, String lastName, String office) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.office = office;
  }

  public String getFirstName() {
    return(firstName);
  }

  public String getLastName() {
    return(lastName);
  }

  public String getOffice() {
    return(office);
  }
  
  @Override
  public String toString() {
    return(String.format("%s %s [%s]", 
           firstName, lastName, office));
  }
}
