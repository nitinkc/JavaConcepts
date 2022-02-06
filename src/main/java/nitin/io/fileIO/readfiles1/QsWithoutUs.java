package nitin.io.fileIO.readfiles1;

import java.nio.file.Files;
import java.nio.file.Paths;

public class QsWithoutUs {
    public static void main(String[] args) throws Exception {
        String inputFile = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/enable1-word-list.txt";
        long wordCount =
                Files.lines(Paths.get(inputFile))
                        .filter(word -> word.contains("q"))
                        .filter(word -> !word.contains("qu"))
                        .count();
        System.out.printf("%s words with q but not u.%n", wordCount);
    }
}
