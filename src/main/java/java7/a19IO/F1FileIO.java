package java7.a19IO;

import java.io.File;
import java.io.IOException;

/**
 * Created by nitin on 1/2/16.
 * Checking if the File Exists. If not Create
 *
 * File class is used to represent DIRECTORIES as well as FILES
 */

public class F1FileIO {

    //FILE CLASS ACCEPTS FILE NAME
    public static void main(String[] args) {
        // Searches the file in the Project root Directory
        File f = new File("nitin.txt");

        // "/" is the root Directory, thus this name is not correct
        File f1 = new File("/src/com/nitin/a19IO/nitin.txt");

        // This is the location the the file from the PROJECT ROOT DIRECTORY!!
        // This cunstructor accepts directoy from Project root and file name
        File f2 = new File("src/com/nitin/a19IO", "nitin.txt");

        //Checking is exists
        System.out.println(f.exists());

        //Creatiomng of a new File - IN THE ROOT PROJECT FOLDER!!
        try {
           f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Checking is exists
        System.out.println(f2.exists());

    }
}