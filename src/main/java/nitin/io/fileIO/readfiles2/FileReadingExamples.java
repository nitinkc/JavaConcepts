package nitin.io.fileIO.readfiles2;

import java.util.Arrays;
import java.util.List;

public class FileReadingExamples {
  public static void main(String[] args) {
    String filename = "src/main/java/nitin/iO/fileIO/enable1-word-list.txt";
    if (args.length > 0) {
      filename = args[0];
    }
    testAllPalindromes(filename);
    test3LetterPalindromes(filename);
  }
  
  public static void testAllPalindromes(String filename) {
    List<String> testWords = Arrays.asList("bog", "bob", "dam", "dad");
    System.out.printf("All palindromes in list %s:%n", testWords);
    FileUtils.printAllPalindromes(testWords.stream());
    System.out.printf("All palindromes in file %s:%n", filename);
    FileUtils.printAllPalindromes(filename);
  }
  
  public static void test3LetterPalindromes(String filename) {
    List<String> testWords = Arrays.asList("bog", "bob", "dam", "dad", "kook", "noon");
    System.out.printf("3-letter palindromes in list %s:%n", testWords);
    FileUtils.printPalindromes(testWords.stream(), 3);
    System.out.printf("3-letter palindromes in file %s:%n", filename);
    FileUtils.printPalindromes(filename, 3);
  }
}
