package com.nitin.zCoreServletsTraining.t4FileIO.fileIOEx1;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

/** Solutions to first set of File I/O exercises from Java 8 tutorial at coreservlets.com.
 *  These solutions use the overly simplistic approach where main throws Exception, because we
 *  have not yet seen how to fix this without repeating code from problem to problem.
 *  We will use a better approach in the second set of exercises.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, Angular 2,
 *  GWT, Android, Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java). Java 9 topics coming soon.</a>.
 */ 

public class FileIoExamples {
  public static void main(String[] args) throws Exception {
    String inputFile = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIOEx1/enable1-word-list.txt";
    nLetterWord(inputFile, 10);
    abcWord(inputFile);
    abcWordMixedCase(inputFile);
    longestWordWithout(inputFile, "a", "e");
    shortestWordWith(inputFile, "q");
    storeTwitterList(inputFile, "twitter-words.txt");
    numPathsInProject();
    storeNums(17, 100, "random-nums.txt");
  }
  
  public static void nLetterWord(String inputFile, int wordLength) throws Exception {
    String errorMessage = String.format("No %s-letter word found", wordLength);
    String result =     
        Files.lines(Paths.get(inputFile))
             .filter(word -> word.length() == wordLength)
             .findFirst()
             .orElse(errorMessage);
    System.out.printf("First %s-letter word is '%s'.%n", wordLength, result);
  }
  
  public static void abcWord(String inputFile) throws Exception {
    String result =     
        Files.lines(Paths.get(inputFile))
              .filter(word -> word.length() == 8)
              .filter(word -> word.contains("a"))
              .filter(word -> word.contains("b"))
              .filter(word -> word.contains("c"))
              .findFirst()
              .orElse("No 8-letter word containing a, b, and c");
    System.out.printf("First 8-letter word containing a, b, and c is '%s'.%n", result);
  }
  
  public static void abcWordMixedCase(String inputFile) throws Exception {
    String result =     
        Files.lines(Paths.get(inputFile))
              .map(String::toLowerCase)   
              .filter(word -> word.length() == 8)
              .filter(word -> word.contains("a"))
              .filter(word -> word.contains("b"))
              .filter(word -> word.contains("c"))
              .findFirst()
              .orElse("No 8-letter word containing a, b, and c");
    System.out.printf("First 8-letter word containing a, b, and c in any case is '%s'.%n", result);
  }
  
  public static void longestWordWithout(String inputFile, String letter1, String letter2) throws Exception {
    String errorMessage = String.format("There is no word that lacks both %s and %s", letter1, letter2);
    String result =     
        Files.lines(Paths.get(inputFile))
             .filter(word -> !word.contains(letter1))
             .filter(word -> !word.contains(letter2))
             .max(Comparator.comparing(String::length))
             .orElse(errorMessage);
    System.out.printf("The longest word that lacks both %s and %s is '%s'.%n", letter1, letter2, result);
  }
  
  public static void shortestWordWith(String inputFile, String letter) throws Exception {
    String errorMessage = String.format("There is no word that contains %s", letter);
    String result =     
        Files.lines(Paths.get(inputFile))
             .filter(word -> word.contains(letter))
             .min(Comparator.comparing(String::length))
             .orElse(errorMessage);
    System.out.printf("The shortest word that contains %s is '%s'.%n", letter, result);
  }
  
  public static void storeTwitterList(String inputFile, String outputFile) throws Exception {
    List<String> twitterWords = 
        Files.lines(Paths.get(inputFile))
             .map(String::toUpperCase)
             .filter(word -> word.contains("WOW") || word.contains("COOL"))
             .map(word -> word + "!")
             .sorted()
             .collect(Collectors.toList());
    Path outputPath = Paths.get(outputFile);
    Files.write(outputPath, twitterWords, Charset.defaultCharset());
    System.out.printf("Wrote %s words to %s.%n", twitterWords.size(), outputPath.toAbsolutePath());
  }
  
  public static void numPathsInProject() throws Exception {
    long numFiles = Files.walk(Paths.get(".")).count();
    System.out.printf("There are %s files and folders in the project.%n", numFiles);
  }
  
  public static void storeNums(int n, int range, String outputFile) {
    Charset characterSet = Charset.defaultCharset();
    Path path = Paths.get(outputFile);
    try (PrintWriter writer = 
             new PrintWriter(Files.newBufferedWriter(path, characterSet))) {
      for(int i=0; i<n; i++) {
        writer.printf("%.2f%n", 10 * Math.random());
      }
      System.out.printf("Wrote %s numbers between 0 and %s to %s.%n", n, range, path.toAbsolutePath());
    } catch (IOException ioe) {
      System.err.println("IOException: " + ioe);
    }
  }
  
  private FileIoExamples() {} // Uninstantiatable class
}
