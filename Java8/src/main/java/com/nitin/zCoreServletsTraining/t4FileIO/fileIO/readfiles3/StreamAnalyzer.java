package com.nitin.zCoreServletsTraining.t4FileIO.fileIO.readfiles3;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

@FunctionalInterface
public interface StreamAnalyzer<T> {
  T analyzeStream(Stream<String> strings);
  
  public static <T> T analyzeFile(String filename, StreamAnalyzer<T> analyzer) {
    try(Stream<String> lines = Files.lines(Paths.get(filename))) {
      return(analyzer.analyzeStream(lines));
    } catch(IOException ioe) {
      System.err.println("Error reading file: " + ioe);
      return(null);
    }
  }
}
