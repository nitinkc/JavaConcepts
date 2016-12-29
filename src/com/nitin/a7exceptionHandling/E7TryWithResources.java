package com.nitin.a7exceptionHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Nitin C on 11/27/2015.
 *
 * The try-with-resources syntax was introduced in java 7, automatically closes all resources opened in the
 * try clause. This feature is known as automatic resource management
 *
 * REMEMBER: Only try-with-resources statement is permitted to omit both that catch and finally blocks
 *
 * The resources created in the try clause are only in scope within the try block.
 */
public class E7TryWithResources {

    public static void main(String[] args) {

    }

    public void newApproach(Path p1, Path p2)  throws Exception{
        try(BufferedReader in = Files.newBufferedReader(p1);
            BufferedWriter out = Files.newBufferedWriter(p2)){
            out.write(in.readLine());
        }
    }

}
