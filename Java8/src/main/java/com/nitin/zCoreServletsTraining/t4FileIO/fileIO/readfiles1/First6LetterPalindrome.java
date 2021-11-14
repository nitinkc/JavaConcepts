package com.nitin.zCoreServletsTraining.t4FileIO.fileIO.readfiles1;

import com.nitin.zCoreServletsTraining.t4FileIO.fileIO.strings.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class First6LetterPalindrome {
  public static void main(String[] args) throws Exception {
    String inputFile = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/enable1-word-list.txt";
    String firstPalindrome = 
        Files.lines(Paths.get(inputFile))
             .filter(word -> word.length() == 6)
             .filter(StringUtils::isPalindrome)
             .findFirst()
             .orElse(null);
    System.out.printf("First 6-letter palindrome is %s.%n", firstPalindrome);
  }
}
