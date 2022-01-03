package nitin.LambdaExpressions.t1Lambdas.lambdas3Ex;

import java.util.Arrays;
import java.util.List;

public class FunctionExamples {
  public static void main(String[] args) {
    List<String> words = 
        Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
    System.out.printf("Original words: %s.%n", words);
    List<String> excitingWords = 
        StringUtils.transformedList(words, s -> s + "!");
    System.out.printf("Exciting words: %s.%n", excitingWords);
    List<String> eyeWords = 
        StringUtils.transformedList(words, s -> s.replace("i", "eye"));
    System.out.printf("Eye words: %s.%n", eyeWords);
    List<String> upperCaseWords = 
        StringUtils.transformedList(words, String::toUpperCase);
    // SAME AS  List<String> upperCaseWords = StringUtils.transformedList(words, s -> s.toUpperCase());
    System.out.printf("Uppercase words: %s.%n", upperCaseWords);
    List<String> excitingWords2 = 
        ElementUtils.transformedList(words, s -> s + "!");
    System.out.printf("Exciting words: %s.%n", excitingWords2);
    List<String> eyeWords2 = 
        ElementUtils.transformedList(words, s -> s.replace("i", "eye"));
    System.out.printf("Eye words: %s.%n", eyeWords2);
    List<String> upperCaseWords2 = 
        ElementUtils.transformedList(words, String::toUpperCase);
    System.out.printf("Uppercase words: %s.%n", upperCaseWords2);
    List<Integer> wordLengths =
        ElementUtils.transformedList(words, String::length);
    System.out.printf("Word lengths: %s.%n", wordLengths);
  }
}
