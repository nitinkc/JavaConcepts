package java.zCoreServletsTraining.t4FileIO.fileIO.readfiles2;

import java.zCoreServletsTraining.t4FileIO.fileIO.strings.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/** Prints all palindromes and all n-length palindromes. Uses the second
 *  file-reading variation, where the code is split into a file-processing method
 *  and a stream-processing method, but code in the file-processing method is
 *  repeated from example to example.
 *  */

public class FileUtils {
  
  /** Prints all palindromes in the Stream. */
  
  public static void printAllPalindromes(Stream<String> words) {
    words.filter(StringUtils::isPalindrome)
         .forEach(System.out::println);
  }
  
  /** Prints all palindromes in the file. */
  
  public static void printAllPalindromes(String filename) {
    try(Stream<String> words = Files.lines(Paths.get(filename))) {
      printAllPalindromes(words);
    } catch(IOException ioe) {
      System.err.println("Error reading file: " + ioe);
    }
  }
  
  /** Prints the n-length palindromes in the Stream. */
  
  public static void printPalindromes(Stream<String> words, int length) {
    words.filter(word -> word.length() == length)
         .filter(StringUtils::isPalindrome)
         .forEach(System.out::println);
  }
  
  /** Prints the n-length palindromes in the file. */
  
  public static void printPalindromes(String filename, int length) {
    try(Stream<String> words = Files.lines(Paths.get(filename))) {
      printPalindromes(words, length);
    } catch(IOException ioe) {
      System.err.println("Error reading file: " + ioe);
    }
  }
}
