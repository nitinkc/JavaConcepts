package nitin.io.fileIO.java7;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
    public static List<String> getLines(String file) throws IOException {
        Path path = Paths.get(file);
        return (Files.readAllLines(path, Charset.defaultCharset()));
    }

    public static Path writeLines(String file, List<String> lines) throws IOException {
        Path path = Paths.get(file);
        return (Files.write(path, lines, Charset.defaultCharset()));
    }

    private FileUtils() {
    } // Uninstantiatable class
}
