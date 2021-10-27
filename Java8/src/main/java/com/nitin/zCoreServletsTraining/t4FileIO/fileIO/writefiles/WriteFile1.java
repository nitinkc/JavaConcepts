package com.nitin.zCoreServletsTraining.t4FileIO.fileIO.writefiles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/** Writes to a file from a List in one fell swoop. Works in either
 *  Java 7 or Java 8, unlike the file reading examples that used
 *  Files.lines, which work only in Java 8.
 * */

public class WriteFile1 {
  public static void main(String[] args) throws IOException {
    Charset characterSet = Charset.defaultCharset();
    Path path = Paths.get("Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/output-file-1.txt");
    List<String> lines = 
      Arrays.asList("Line One", "Line Two", "Final Line");
    Files.write(path, lines, characterSet);
  }
}
