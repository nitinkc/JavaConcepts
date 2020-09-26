package com.nitin.zCoreServletsTraining.t4FileIO.fileIO.strings;

/** This class was created for use in the File IO section,
 *  and is also used as an example in the JUnit section.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class StringUtils {
  
  /** Returns a reversed copy of a non-null String. */
  
  public static String reverseString(String s) {
    return(new StringBuilder(s).reverse().toString());
  }
  
  /** Checks if a String is a palindrome. Accepts
   *  zero-length or one-length strings, but not null.
   */
  public static boolean isPalindrome(String s) {
    return(s.equalsIgnoreCase(reverseString(s)));
  }
  
  private StringUtils() {} // Uninstantiatable class: static methods only
}
