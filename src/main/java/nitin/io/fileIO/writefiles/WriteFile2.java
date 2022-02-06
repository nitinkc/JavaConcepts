package nitin.zCoreServletsTraining.t4FileIO.fileIO.writefiles;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Writes to file without having to make List first. Uses BufferedWriter directly.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 * Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 * servlets, JSP, Java 8 lambdas and streams (for those that know Java already),
 * and Java 8 programming (for those new to Java)</a>.
 */

public class WriteFile2 {
    public static void main(String[] args) {
        Charset characterSet = Charset.defaultCharset();
        int numLines = 10;
        Path path = Paths.get("src/main/java/nitin/zCoreServletsTraining/t4FileIO/fileIO/output-file-2.txt");
        try (BufferedWriter writer =
                     Files.newBufferedWriter(path, characterSet)) {
            for (int i = 0; i < numLines; i++) {
                writer.write("Number is " + 100 * Math.random());
                writer.newLine();
            }
        } catch (IOException ioe) {
            System.err.printf("IOException: %s%n", ioe);
        }
    }
}
