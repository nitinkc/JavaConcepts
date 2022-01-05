package nitin.io.fileIO.readfiles3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Reusable processFile method inspired by suggestion from
// Jeff Lin of the Johns Hopkins Applied Physics Lab.

@FunctionalInterface
public interface StreamProcessor {
  void processStream(Stream<String> strings);
  
  public static void processFile(String filename, StreamProcessor processor) {
    try(Stream<String> lines = Files.lines(Paths.get(filename))) {
      processor.processStream(lines);
    } catch(IOException ioe) {
      System.err.println("Error reading file: " + ioe);
    }
  }
}
