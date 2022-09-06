package nitin.io.fileIO.readfiles1;

import com.config.Configs;

import java.nio.file.Files;
import java.nio.file.Paths;

public class QsWithoutUs {
    public static void main(String[] args) throws Exception {
        String inputFile = Configs.ENABLE1_WORD_LIST_PATH;
        long wordCount =
                Files.lines(Paths.get(inputFile))
                        .filter(word -> word.contains("q"))
                        .filter(word -> !word.contains("qu"))
                        .count();
        System.out.printf("%s words with q but not u.%n", wordCount);
    }
}
