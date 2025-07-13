package nitin.io.fileOperations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Created by nichaurasia Created on Sunday, December/20/2020 at 7:34 PM
 */
public class FileReadWrite {
    public static void main(String[] args) throws IOException {
        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "Temporary text data");
        System.out.println(path);

        String s = Files.readString(path);
        System.out.println(s);
    }
}
