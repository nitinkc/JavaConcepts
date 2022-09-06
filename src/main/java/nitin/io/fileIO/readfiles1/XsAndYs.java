package nitin.io.fileIO.readfiles1;

import com.config.Configs;

import java.nio.file.Files;
import java.nio.file.Paths;

public class XsAndYs {
    public static void main(String[] args) throws Exception {
        String inputFile = Configs.ENABLE1_WORD_LIST_PATH;
        int letterCount =
                Files.lines(Paths.get(inputFile))
                        .filter(word -> word.contains("x"))
                        .filter(word -> word.contains("y"))
                        .mapToInt(String::length)
                        .sum();
        System.out.printf("%,d total letters in words with " +
                "both x and y.%n", letterCount);
    }
}
