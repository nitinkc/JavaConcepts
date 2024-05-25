package nitin.io.fileIO.fileIOEx2;

import java.util.stream.Stream;

/**
 * Some Stream-based static methods for finding words in files.
 */
public class WordUtils {
    private WordUtils() {
    } // Uninstantiatable class

    public static void print10LetterWord(Stream<String> words) {
        String result =
                words.filter(word -> word.length() == 10)
                        .findFirst()
                        .orElse("No 10-letter word found");
        System.out.printf("First 10-letter word is '%s'.%n", result);
    }

    public static void print10LetterWord(String filename) {
        StreamProcessor.processFile(filename, WordUtils::print10LetterWord);
    }

    public static void printNLetterWord(Stream<String> words, int wordLength) {
        String errorMessage = String.format("No %s-letter word found", wordLength);
        String result =
                words.filter(word -> word.length() == wordLength)
                        .findFirst()
                        .orElse(errorMessage);
        System.out.printf("First %s-letter word is '%s'.%n", wordLength, result);
    }

    public static void printNLetterWord(String filename, int wordLength) {
        StreamProcessor.processFile(filename, words -> printNLetterWord(words, wordLength));
    }

    public static String nLetterWord(Stream<String> words, int wordLength) {
        return (words.filter(word -> word.length() == wordLength)
                .findFirst()
                .orElse(null));
    }

    public static String nLetterWord(String filename, int wordLength) {
        return (StreamAnalyzer.analyzeFile(filename, lines -> nLetterWord(lines, wordLength)));
    }

    public static long numWordsContaining(Stream<String> words, String subString) {
        return (words.filter(word -> word.contains(subString))
                .count());
    }

    public static long numWordsContaining(String filename, String subString) {
        return (StreamAnalyzer.analyzeFile(filename, lines -> numWordsContaining(lines, subString)));
    }
}
