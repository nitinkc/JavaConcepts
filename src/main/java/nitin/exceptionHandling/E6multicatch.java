package nitin.exceptionHandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

/**
 * Created by Nitin C on 3/5/2016.
 * multi-catch block
 * In Java 7, they introduce the the ability to catch multiple exceptions in the same catch block.
 * catch (FileNotFoundException | IOException e) redundant exceptions gives the error.
 * Error MULTI-CATCH Must be disjoint
 * <p>
 * Multi-catch is effectively final
 */
public class E6multicatch {
    public static void main(String[] args) {
        String filePath = "src/main/resources/test.txt";
        String writeMe = "Testing";
        readFile(filePath, writeMe);
        //---------------
        Path path = Paths.get("text.txt");
        String text = null;
        try {
            text = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDate date = LocalDate.parse(text);
        System.out.println(date);
    }

    public static Integer readFile(String path, String writeMe) {

        //Try with Resource
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)))) {
            writeMe = writeMe + " :: " + 1;
            oos.writeObject(writeMe);

        } catch (IOException | ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Always Run this as well");
        }
        return null;
    }
}
