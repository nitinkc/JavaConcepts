package nitin.io.fileIO.fileIOEx2;

import com.config.Configs;
import java.util.Arrays;
import java.util.List;

/** Solutions to second set of file I/O exercises from Java 8 tutorial at coreservlets.com. */
public class FileIOExamples {
    public static void main(String[] args) {
        String filename = Configs.ENABLE1_WORD_LIST_PATH;
        List<String> testWords = Arrays.asList("foo", "bar", "baz12345678", "boo1234567");

        WordUtils.print10LetterWord(testWords.stream());
        WordUtils.print10LetterWord(filename);

        WordUtils.printNLetterWord(testWords.stream(), 11);
        WordUtils.printNLetterWord(filename, 11);

        for (int wordLength = 2; wordLength < 13; wordLength++) {
            String result1 = WordUtils.nLetterWord(testWords.stream(), wordLength);
            if (result1 != null) {
                System.out.printf("First %s-letter word in list is '%s'.%n", wordLength, result1);
            } else {
                System.out.printf("No %s-letter word in list.%n", wordLength);
            }
            String result2 = WordUtils.nLetterWord(filename, wordLength);
            if (result2 != null) {
                System.out.printf("First %s-letter word in file is '%s'.%n", wordLength, result2);
            } else {
                System.out.printf("No %s-letter word in file.%n", wordLength);
            }
        }

        List<String> testWords2 =
                Arrays.asList("quit", "squid", "book", "bookkeeper", "keep", "steep");
        long qsInList = WordUtils.numWordsContaining(testWords2.stream(), "q");
        long jsInList = WordUtils.numWordsContaining(testWords2.stream(), "j");
        System.out.printf(
                "In list, there are %,d words containing 'q' and %,d words containing 'j'.%n",
                qsInList, jsInList);
        long qsInFile = WordUtils.numWordsContaining(filename, "q");
        long jsInFile = WordUtils.numWordsContaining(filename, "j");
        System.out.printf(
                "In file, there are %,d words containing 'q' and %,d words containing 'j'.%n",
                qsInFile, jsInFile);
        long doubleOsInList = WordUtils.numWordsContaining(testWords2.stream(), "oo");
        long doubleEsInList = WordUtils.numWordsContaining(testWords2.stream(), "ee");
        System.out.printf(
                "In list, there are %,d words containing 'oo' and %,d words containing 'ee'.%n",
                doubleOsInList, doubleEsInList);
        long doubleOsInFile = WordUtils.numWordsContaining(filename, "oo");
        long doubleEsInFile = WordUtils.numWordsContaining(filename, "ee");
        System.out.printf(
                "In file, there are %,d words containing 'oo' and %,d words containing 'ee'.%n",
                doubleOsInFile, doubleEsInFile);
    }
}
