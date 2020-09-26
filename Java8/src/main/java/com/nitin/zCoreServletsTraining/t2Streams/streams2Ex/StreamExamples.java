package com.nitin.zCoreServletsTraining.t2Streams.streams2Ex;

import java.util.*;

/** Solutions to second set of Stream exercises from Java 8 tutorial at coreservlets.com.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, Angular 2,
 *  GWT, Android, Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java). Java 9 topics coming soon.</a>.
 */

public class StreamExamples {
  public static void main(String[] args) {
    List<String> words = 
        Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
    System.out.printf("Original words: %s.%n", words);
    //  Stream<String> wordStream = words.stream();  Then, reuse wordStream. NO!! Why not?
    
    // Question: do I need toUpperCase on s1?
    // Answer:   no.
    String upperCaseWords = 
        words.stream().reduce("", (s1, s2) -> s1 + s2.toUpperCase());
    System.out.printf("Single uppercase String: %s.%n", 
                      upperCaseWords);
    
    // Alternative solution to problem 1: change into uppercase
    // at the end instead of as you go along.
    String upperCaseWordsAlt = 
        words.stream().reduce("", String::concat).toUpperCase();
    System.out.printf("Single uppercase String: %s.%n", 
                      upperCaseWordsAlt);
    
    String upperCaseWords2 = 
        words.stream().map(String::toUpperCase)     // Or .map (s -> s.toUpperCase())
                      .reduce("", String::concat);  // Or .reduce("", (s1,s2) -> s1+s2)
    System.out.printf("Single uppercase String: %s.%n", 
                      upperCaseWords2);
    
    String wordsWithCommas = 
        words.stream().reduce((s1, s2) -> s1 + "," + s2)
                      .orElse("need at least two strings");
    System.out.printf("Comma-separated String: %s.%n", 
                      wordsWithCommas);
    
    int numberOfChars =
        words.stream().mapToInt(String::length)
                      .sum();
    System.out.printf("Total number of characters: %s.%n", 
                      numberOfChars);
    
    long numberOfWordsWithH =
        words.stream().filter(s -> s.contains("h"))
                      .count();
    System.out.printf("Number of words containing 'h': %s.%n", 
                      numberOfWordsWithH);
  }
}
