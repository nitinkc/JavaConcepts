package nitin.exceptionHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nitin C on 11/27/2015.
 * <p>
 * The try-with-resources syntax was introduced in java 7, automatically closes all resources opened in the
 * try clause. This feature is known as automatic resource management
 * <p>
 * REMEMBER: Only try-with-resources statement is permitted to omit both that catch and finally blocks
 * <p>
 * The resources created in the try clause are only in scope within the try block.
 */
public class E7TryWithResources {
    public static final String P1 = "src/main/resources/p1.txt";
    public static final String P2  = "src/main/resources/p2.txt";

    public static void main(String[] args) {
        Path inputPath = Paths.get(P1);
        Path outputPath = Paths.get(P2);
        newApproach(inputPath,outputPath);
    }

    public static void newApproach(Path p1, Path p2){
        try (BufferedReader in = Files.newBufferedReader(p1);
             BufferedWriter out = Files.newBufferedWriter(p2)) {
            out.write(in.readLine());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
