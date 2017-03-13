package com.nitin.a20NIO_2;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Nitin C on 3/4/2016.
 */
public class N1PathFileTest {
    public static void main(String[] args) {
        printPathInformation(Paths.get("/src/nitin.txt"));
    }

    private static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is " + path.getRoot());

        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null){
            System.out.println(" Current parent is: "+currentParent);
        }
    }
}
