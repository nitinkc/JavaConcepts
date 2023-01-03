package nitin.exceptionHandling;

import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
}
