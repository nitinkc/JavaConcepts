package com.nitin.zCoreServletsTraining.t4FileIO.fileIO.readfiles3;

import com.nitin.zCoreServletsTraining.t4FileIO.fileIO.strings.StringUtils;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Finds various information about the word list. Uses the third and fourth
 *  file-reading variations, where the code is split into a file-processing method
 *  and a stream-processing method, and code in the file-processing method is
 *  NOT repeated from example to example.
 */

public class FileUtils {
  
  /** Prints all palindromes in the Stream. */
  
  public static void printAllPalindromes(Stream<String> words) {
    words.filter(StringUtils::isPalindrome)
         .forEach(System.out::println);
  }
  
  /** Prints all palindromes in the file. */
  
  public static void printAllPalindromes(String filename) {
    StreamProcessor.processFile(filename, FileUtils::printAllPalindromes);
  }
  
  /** Prints the n-length palindromes in the Stream. */
  
  public static void printPalindromes(Stream<String> words, int length) {
    words.filter(word -> word.length() == length)
         .filter(StringUtils::isPalindrome)
         .forEach(System.out::println);
  }
  
  /** Prints the n-length palindromes in the file. */
  
  public static void printPalindromes(String filename, int length) {
    StreamProcessor.processFile(filename, lines -> printPalindromes(lines, length));
  }

  /** Returns the first palindrome in the Stream. 
   *  Returns null if there is no match.
   */
  
  public static String firstPalindrome(Stream<String> words) {
    return(words.filter(StringUtils::isPalindrome)
                .findFirst()
                .orElse(null));
  }
  
  /** Returns the first palindrome in the file. 
   *  Returns null if there is no match.
   */
    
  public static String firstPalindrome(String filename) {
    return(StreamAnalyzer.analyzeFile(filename, FileUtils::firstPalindrome));
  }
  
  // @SafeVarargs is difficult to understand. The issue is that it is not always safe to use varargs for generic types: 
  // the resultant array can have runtime type problems if you modify entries in it.  
  // But, if you only read the values and never modify them, varargs is perfectly safe.
  // @SafeVarargs says "I am not doing anything dangerous, please suppress the compiler warnings".  
  // For details, see http://docs.oracle.com/javase/8/docs/technotes/guides/language/non-reifiable-varargs.html
  
  /** Returns a Predicate that is the result of ANDing all the argument Predicates.
   *  If no Predicates are supplied, it returns a Predicate that always returns
   *  true.
   */
  
  @SafeVarargs
  public static <T> Predicate<T> combinedPredicate(Predicate<T>... tests) {
    Predicate<T> result = e -> true;
    for(Predicate<T> test: tests) {
      result = result.and(test);
    }
    return(result);
  }
  
  /** Returns first element in Stream that passes all of the tests. 
   *  Returns null if there is no match.
   */
  
  @SafeVarargs
  public static <T> T firstMatch(Stream<T> elements, Predicate<T>... tests) {
    Predicate<T> combinedTest = FileUtils.combinedPredicate(tests);
    return(elements.filter(combinedTest)
                   .findFirst()
                   .orElse(null));
  }
  
  /** Returns first line in file that passes all of the tests. 
   *  Returns null if there is no match.
   */
  
  @SafeVarargs
  public static String firstMatch(String filename, Predicate<String>... tests) {
    return(StreamAnalyzer.analyzeFile(filename, stream -> firstMatch(stream, tests)));
  }
  
  /** Returns a List<T> of all elements in Stream that pass all of the tests. 
   *  Returns an empty List if there is no match.
   */
  
  @SafeVarargs
  public static <T> List<T> allMatches(Stream<T> elements, Predicate<T>... tests) {
    Predicate<T> combinedTest = FileUtils.combinedPredicate(tests);
    return(elements.filter(combinedTest)
                   .collect(Collectors.toList()));
  }
  
  /** Returns a List<String> of all lines in file that pass all of the tests. 
   *  Returns an empty List if there is no match.
   */
  
  @SafeVarargs
  public static List<String> allMatches(String filename, Predicate<String>... tests) {
    return(StreamAnalyzer.analyzeFile(filename, stream -> allMatches(stream, tests)));
  }
  
  /** Returns sum of the lengths of all words in the Stream that pass the tests. 
   *  Returns 0 in no words pass all the tests. 
   */
  @SafeVarargs
  public static int letterCount(Stream<String> words, Predicate<String>... tests) {
    Predicate<String> combinedTest = FileUtils.combinedPredicate(tests);
    return(words.filter(combinedTest)
                .mapToInt(String::length)
                .sum());
  }
  
  /** Returns sum of the lengths of all lines in the file that pass the tests. 
   *  Returns 0 in no lines pass all the tests. 
   */
  @SafeVarargs
  public static Integer letterCount(String filename, Predicate<String>... tests) {
    return(StreamAnalyzer.analyzeFile(filename, stream -> letterCount(stream, tests)));
  }
  
  private FileUtils() {} // Uninstantiatable class: static methods only
}
