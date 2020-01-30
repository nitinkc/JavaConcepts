package com.nitin.a17Streams.fileStreams;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nichaurasia on Tuesday, January/28/2020 at 3:55 PM
 */

public class FileStream {
    public static void main(String args[]) throws URISyntaxException, IOException {
        String fileName = "src/main/resources/cancer.csv";
        Path path = Paths.get(fileName);

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream
                    .map(str -> str.split(","))
                    .collect(Collectors.groupingBy()
                    .forEach((str, lng) -> System.out.println(str[0] + " : " +lng));
                  //.filter(str -> str.equalsIgnoreCase("Alabama"))
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
