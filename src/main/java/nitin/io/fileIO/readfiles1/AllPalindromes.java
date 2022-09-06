package nitin.io.fileIO.readfiles1;


import com.config.Configs;
import nitin.io.fileIO.strings.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Prints all palindromes. Uses the first, simplest, and least flexible
 * file-reading variation, where code is placed directly in "main".
 */

public class AllPalindromes {
    public static void main(String[] args) {
        String inputFile = Configs.ENABLE1_WORD_LIST_PATH;

        try {
            Files.lines(Paths.get(inputFile))
                    .filter(StringUtils::isPalindrome)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
