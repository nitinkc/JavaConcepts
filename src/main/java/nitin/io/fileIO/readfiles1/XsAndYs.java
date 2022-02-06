package nitin.io.fileIO.readfiles1;

import java.nio.file.Files;
import java.nio.file.Paths;

public class XsAndYs {
    public static void main(String[] args) throws Exception {
        String inputFile = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/enable1-word-list.txt";
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
