package com.nitin.zCoreServletsTraining.t4FileIO.fileIO.java7;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

public class FileUtils {
  public static List<String> getLines(String file) throws IOException {
    Path path = Paths.get(file);
    return(Files.readAllLines(path, Charset.defaultCharset()));
  }
  
  public static Path writeLines(String file, List<String> lines) throws IOException {
    Path path = Paths.get(file);
    return(Files.write(path, lines, Charset.defaultCharset()));
  }
  
  private FileUtils() {} // Uninstantiatable class
}
