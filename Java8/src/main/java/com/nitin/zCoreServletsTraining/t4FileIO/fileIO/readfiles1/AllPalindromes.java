package com.nitin.zCoreServletsTraining.t4FileIO.fileIO.readfiles1;

import java.nio.file.*;
import com.nitin.zCoreServletsTraining.t4FileIO.fileIO.strings.*;

/** Prints all palindromes. Uses the first, simplest, and least flexible
 *  file-reading variation, where code is placed directly in "main".
 */

public class AllPalindromes {
  public static void main(String[] args) throws Exception {
    String inputFile = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/enable1-word-list.txt";

    Files.lines(Paths.get(inputFile))
         .filter(StringUtils::isPalindrome)
         .forEach(System.out::println);
  }
}
