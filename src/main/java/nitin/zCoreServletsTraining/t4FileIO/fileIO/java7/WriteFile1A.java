package nitin.zCoreServletsTraining.t4FileIO.fileIO.java7;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteFile1A {
  public static void main(String[] args) throws IOException {
    String file = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/OutputFile1.txt";

    List<String> lines = 
      Arrays.asList("Line One", "Line Two", "Final Line");
    FileUtils.writeLines(file, lines);
  }
}
