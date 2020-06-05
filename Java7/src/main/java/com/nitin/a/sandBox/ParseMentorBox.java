package com.nitin.a.sandBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Nitin Chaurasia on 2/15/18 at 8:47 PM.
 */
public class ParseMentorBox {
    public static void main(String args[]) {
        System.out.println("Hello");

        final String O_FILENAME = "/Users/nitin/OneDrive/Programming/Java/IntelliJ/output_mentorBox.txt";
        final String IN_FILENAME = "/Users/nitin/OneDrive/Programming/Java/IntelliJ/mentorBox.html";
        final String searchTitle = "          <div class='course-listing-title'>";
        final String searchSubTitle = "          <div class='course-listing-subtitle'>";

        //Open the File
        File myFile = new File(IN_FILENAME);
        Scanner in = null;
        try {
            in = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Instead of System.in, take the file to read

        // Output File
        //Surrounding with try catch!!
        PrintWriter output = null;
        try {
            output = new PrintWriter(O_FILENAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int titleCount = 0, subTitleCount = 0;
        while (in.hasNext()) {
            String str = in.nextLine();
            if (str.equals(searchTitle)){
                output.print(in.nextLine() + "\t ||");
                System.out.println(str);
                titleCount++;
            }

            if (str.equals(searchSubTitle)){
                output.println(in.nextLine());
                System.out.println(str);
                output.println("*******************");
                subTitleCount++;
            }
        }

        output.println("Total Titles found : " + titleCount);
        System.out.println("Total Titles found : " + titleCount);
        System.out.println("Total Subtitles found : " + subTitleCount);

        //Close the File
        in.close();
        output.close();
    }
}
