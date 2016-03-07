package com.nitin.IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by nitin on 1/2/16.
 */
public class F2FileReaderWriter {
    public static void main(String[] args) throws IOException {
        File f = new File("nitin.txt");

        FileReader fr = new FileReader(f);
        int i = fr.read();

        // Reading character by character
        // We have the Unicode value of the Character
        while(i != -1){ //unicode of null is -1
            System.out.println((char)i);
            i = fr.read();
        }


        // By default, its false, meaning, it will override, Put true to append
        FileWriter fw = new FileWriter(f,true);
        fw.write("  Nitin\n");

        //Good practise to use flush
        fw.flush();


        fr.close();
        fw.close();


    }
}
