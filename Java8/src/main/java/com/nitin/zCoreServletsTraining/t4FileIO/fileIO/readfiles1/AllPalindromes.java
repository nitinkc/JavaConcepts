package com.nitin.zCoreServletsTraining.t4FileIO.fileIO.readfiles1;

import com.nitin.zCoreServletsTraining.t4FileIO.fileIO.strings.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;

/** Prints all palindromes. Uses the first, simplest, and least flexible
 *  file-reading variation, where code is placed directly in "main".
 */

public class AllPalindromes {
  public static void main(String[] args) throws Exception {
    String inputFile = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/readfiles1/enable1-word-list.txt";

    Files.lines(Paths.get(inputFile))
         .filter(StringUtils::isPalindrome)
         .forEach(System.out::println);
  }
}
