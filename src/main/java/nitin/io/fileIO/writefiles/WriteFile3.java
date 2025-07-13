package nitin.zCoreServletsTraining.t4FileIO.fileIO.writefiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Writes to file without having to make List first. Wraps the BufferedWriter in a PrintWriter. */
public class WriteFile3 {
    public static void main(String[] args) {
        Charset characterSet = Charset.defaultCharset();
        int numLines = 10;
        Path path =
                Paths.get(
                        "src/main/java/nitin/zCoreServletsTraining/t4FileIO/fileIO/output-file-3.txt");
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(path, characterSet))) {
            for (int i = 0; i < numLines; i++) {
                out.printf("Number is %5.2f%n", 100 * Math.random());
            }
        } catch (IOException ioe) {
            System.err.printf("IOException: %s%n", ioe);
        }
    }
}
