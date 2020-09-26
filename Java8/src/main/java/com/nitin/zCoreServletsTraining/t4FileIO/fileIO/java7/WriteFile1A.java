package com.nitin.zCoreServletsTraining.t4FileIO.fileIO.java7;

import java.io.*;
import java.util.*;

public class WriteFile1A {
  public static void main(String[] args) throws IOException {
    String file = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/OutputFile1.txt";

    List<String> lines = 
      Arrays.asList("Line One", "Line Two", "Final Line");
    FileUtils.writeLines(file, lines);
  }
}
