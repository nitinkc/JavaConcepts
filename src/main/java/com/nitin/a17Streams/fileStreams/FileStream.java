package com.nitin.a17Streams.fileStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by nichaurasia on Tuesday, January/28/2020 at 3:55 PM
 */

public class FileStream {

    public static void main(String args[]) {

        String fileName = "classpath:resources/cancer.txt";
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get("resources"))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
