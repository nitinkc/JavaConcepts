package nitin.iO.google;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class FileWrite {

    public static void doSomethingParallely(String singleString) {
        Charset characterSet = Charset.defaultCharset();
        Path path = Paths.get("src/main/java/com/google/output.txt");
        try {
            //System.out.println("Writing into file the word :: " + singleString);
            //Files.write(path, Collections.singleton(singleString), characterSet, StandardOpenOption.APPEND);
            Files.write(path, Collections.singleton(singleString), characterSet);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
