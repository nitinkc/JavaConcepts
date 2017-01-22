package com.nitin.a19IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by nitin on 1/2/16.
 */
public class F4PrintReaderWriter {
    public static void main(String[] args) throws IOException {

        File f = new File("src/com/nitin/IO_FileHandling/nitin.txt");

        // Use File writer for appending, WITHOUT IT THE PRINTWRITER OVER WRITES THE FILE!!
        FileWriter fw = new FileWriter(f,true);
        PrintWriter pw = new PrintWriter(fw);

        pw.append("TESTING");
        pw.write("Sangram\n");
        pw.write(100);// This will put 'd'
        pw.println(100);// this will put the int 100
        pw.println('c');

        // DIFFERENDE between append, write and Print (Print can write primity type into the File)
        // TO DO: Find a way to iterate to the EOF using PrintFWriter
        //while(pw.something == EOF)
        pw.flush();
        pw.close();

    }
}
