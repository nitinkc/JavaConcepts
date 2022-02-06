package nitin.io.fileIO.java7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Reads one line at a time, rather than using Files.readAllLines
 * as in ReadFile1.
 */

public class ReadFile2 {
    public static void main(String[] args) {
        String file = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/input-file.txt";
        Charset characterSet = Charset.defaultCharset();
        Path path = Paths.get(file);
        try (BufferedReader reader =
                     Files.newBufferedReader(path, characterSet)) {
            System.out.printf("Lines from %s:%n", file);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            System.err.printf("IOException: %s%n", ioe);
        }
    }
}
