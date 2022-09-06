package nitin.io.fileIO.readfiles1;


import com.config.Configs;
import nitin.io.fileIO.strings.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class First6LetterPalindrome {
    public static void main(String[] args) throws Exception {
        String inputFile = Configs.ENABLE1_WORD_LIST_PATH;
        String firstPalindrome =
                Files.lines(Paths.get(inputFile))
                        .filter(word -> word.length() == 6)
                        .filter(StringUtils::isPalindrome)
                        .findFirst()
                        .orElse(null);
        System.out.printf("First 6-letter palindrome is %s.%n", firstPalindrome);
    }
}
