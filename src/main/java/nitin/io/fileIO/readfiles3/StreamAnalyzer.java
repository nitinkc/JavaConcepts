package nitin.io.fileIO.readfiles3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@FunctionalInterface
public interface StreamAnalyzer<T> {
    static <T> T analyzeFile(String filename, StreamAnalyzer<T> analyzer) {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return (analyzer.analyzeStream(lines));
        } catch (IOException ioe) {
            System.err.println("Error reading file: " + ioe);
            return (null);
        }
    }

    T analyzeStream(Stream<String> strings);
}
