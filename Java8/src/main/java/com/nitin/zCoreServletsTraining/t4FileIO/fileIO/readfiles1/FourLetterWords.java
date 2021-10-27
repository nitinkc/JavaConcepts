package com.nitin.zCoreServletsTraining.t4FileIO.fileIO.readfiles1;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

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
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class FourLetterWords {
  public static void main(String[] args) throws Exception {
    String inputFile = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/enable1-word-list.txt";
    String outputFile = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/four-letter-words.txt";
    int length = 4;
    List<String> words =
        Files.lines(Paths.get(inputFile))
             .filter(word -> word.length() == length)
             .map(String::toUpperCase)
             .distinct()
             .sorted()
             .collect(Collectors.toList());
    Files.write(Paths.get(outputFile), words, Charset.defaultCharset());
    System.out.printf("Wrote %s words to %s.%n", words.size(), outputFile);
  }
}
