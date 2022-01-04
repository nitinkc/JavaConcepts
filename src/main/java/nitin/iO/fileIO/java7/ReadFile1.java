package nitin.iO.fileIO.java7;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/** Reads from file into a List in one fell swoop. Uses
 *  the Java-7 approach with Files.readAllLines, which is much less efficient
 *  than the Java 8 approach with Files.lines.
 */

public class ReadFile1 {
  public static void main(String[] args) throws Exception {
    String file = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/input-file.txt";
    Charset characterSet = Charset.defaultCharset();

    //The Paths.get method is shorthand for the following code:
    //Path path = FileSystems.getDefault().getPath(file);
    Path path = Paths.get(file);
    List<String> lines = Files.readAllLines(path, characterSet);
    System.out.printf("Lines from %s: %s%n", file, lines);
  }
}
