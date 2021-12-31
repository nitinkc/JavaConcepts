package java.zCoreServletsTraining.t4FileIO.fileIO.readfiles3;

import java.zCoreServletsTraining.t4FileIO.fileIO.strings.StringUtils;

import java.util.Arrays;
import java.util.List;

public class FileReadingExamples {
  
  /** The enable1 word list is a public-domain file containing over
   *  175,000 supposed words accepted by many US Scrabble clubs.
   *  The name comes from Enhanced North American Benchmark LExicon (ENABLE).
   *  It is almost twice as large as the Official Scrabble Player's Dictionary,
   *  and contains slang, offensive words, and many obscure or questionable words.
   *  It contains no one-letter words and no super-long words, and is not endorsed
   *  in any way by Hasbro (maker of Scrabble) or Merriam Webster (publisher of
   *  The Official Scrabble Player's Dictionary).
   *  Details at http://www.puzzlers.org/dokuwiki/doku.php?id=solving:wordlists:about:enable_readme
   *  <p>
   *  Two repeated words in mixed case (Extra and EXTRA) were added to the end of the file
   *  to verify that the code can handle repeats, mixed case, and out-of-order entries.
   *  <p>
   *  The project also contains additional word lists for you to experiment with.
   */
  
  public static void main(String[] args) {
    String filename = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/enable1-word-list.txt";
    if (args.length > 0) {
      filename = args[0];
    }
    //testAllPalindromes(filename);
    //testPalindromes(filename, 3, 4, 7);
    //testFirstPalindrome(filename);
    //testLetterCount(filename);
    //testFirstMatch(filename);
    testAllMatches(filename);
  }
  
  public static void testAllPalindromes(String filename) {
    List<String> testWords = 
      Arrays.asList("bog", "bob", "dam", "dad");
    System.out.printf("All palindromes in list %s:%n", testWords);
    FileUtils.printAllPalindromes(testWords.stream());
    System.out.printf("All palindromes in file %s:%n", filename);
    FileUtils.printAllPalindromes(filename);
  }
  
  public static void testPalindromes(String filename, int... lengths) {
    List<String> testWords = 
      Arrays.asList("rob", "bob", "reed", "deed");
    for(int length: lengths) {
      System.out.printf("%s-letter palindromes in list %s:%n", length, testWords);
      FileUtils.printPalindromes(testWords.stream(), length);
      System.out.printf("%s-letter palindromes in file %s:%n", length, filename);
      FileUtils.printPalindromes(filename, length);
    }
  }
  
  public static void testFirstPalindrome(String filename) {
    List<String> testWords = 
      Arrays.asList("bog", "bob", "dam", "dad");
    String firstPalindrome = 
      FileUtils.firstPalindrome(testWords.stream());
    System.out.printf("First palindrome in list %s is %s.%n", testWords, firstPalindrome);
    firstPalindrome = FileUtils.firstPalindrome(filename);
    System.out.printf("First palindrome in file %s is %s.%n", filename, firstPalindrome);
  }
  
  public static void testLetterCount(String filename) {
    List<String> testWords = Arrays.asList("hi", "hello", "hola");
    System.out.printf("In list %s:%n", testWords);
    int sum1 = FileUtils.letterCount(testWords.stream(), 
                                     word -> word.contains("h"),
                                     word -> !word.contains("i"));
    printLetterCountResult(sum1, "contain h but not i");
    System.out.printf("In file %s:%n", filename);
    int sum2 = FileUtils.letterCount(filename,
                                     StringUtils::isPalindrome);
    printLetterCountResult(sum2, "are palindromes");
    int sum3 = FileUtils.letterCount(filename,
                                     word -> word.contains("q"),
                                     word -> !word.contains("qu"));
    printLetterCountResult(sum3, "contain q not followed by u");
    int sum4 = FileUtils.letterCount(filename,
                                     word -> true);
    printLetterCountResult(sum4, "are in English language");
  }

  private static void printLetterCountResult(int sum, String message) {
    System.out.printf("  %,d total letters in words that %s.%n", sum, message);
  }
  
  public static void testFirstMatch(String filename) {
    List<Integer> testNums = Arrays.asList(1, 10, 2, 20, 3, 30);
    Integer match1 = FileUtils.firstMatch(testNums.stream(),
                                          n -> n > 2,
                                          n -> n < 10,
                                          n -> n % 2 == 1);
    System.out.printf("First word in list %s that is greater than 2, less than 10, and odd is %s.%n", testNums, match1);
    String match2 = FileUtils.firstMatch(filename, 
                                         word -> word.contains("q"),
                                         word -> !word.contains("qu"));
    System.out.printf("First word in file %s with q not followed by u is %s.%n", filename, match2);
  }
  
  public static void testAllMatches(String filename) {
    List<Integer> testNums = Arrays.asList(2, 4, 6, 8, 10, 12);
    List<Integer> matches1 = 
        FileUtils.allMatches(testNums.stream(), 
                             n -> n > 5,
                             n -> n < 10);
    System.out.printf("All numbers in list %s that are greater than 5 and less than 10: %s.%n", testNums, matches1);
    List<String> matches2 = FileUtils.allMatches(filename, 
                                                 word -> word.contains("q"),
                                                 word -> !word.contains("qu"));
    System.out.printf("All words in file %s with q not followed by u: %s.%n", filename, matches2);
  }
  
  private FileReadingExamples() {} // Uninstantiatable class: static methods only
}
