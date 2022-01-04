package nitin.iO.fileIO.java7;

import java.util.List;

/** Similar to ReadFile1, but uses a method from FileUtils to simplify the code. */

public class ReadFile1A {
  public static void main(String[] args) throws Exception {
    String file = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/input-file.txt";
    List<String> lines = FileUtils.getLines(file);
    System.out.printf("Lines from %s: %s%n", file, lines);
  }
}
