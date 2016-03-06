package com.nitin.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by nitin on 1/2/16.
 */
public class F6ScannerFromFile {
    public static void main(String[] args) throws FileNotFoundException {
         /* READING THE DATA FROM THE FILE */
        File f = new File("src/com/nitin/IO_FileHandling/nitin.txt");
        Scanner toFile = new Scanner(f);

        while (toFile.hasNext()){
            //Every line is treated as  String
            System.out.println(toFile.next());
        }

        //TO DO: DIFFERENCE Between next() and nextLine()
        //nextLine -> READS THE ENTIRE LINE (Including the \n)(of the keyboard/file input)
        //next() -> Reads the characters upto (but not including) space
        //Resetting the pointer to the Start of the File
        toFile = new Scanner(f);
        while(toFile.hasNext()){
            System.out.println(toFile.nextLine());
        }
    }
}
