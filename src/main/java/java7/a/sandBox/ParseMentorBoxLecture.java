package java7.a.sandBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nitin Chaurasia on 2/15/18 at 8:47 PM.
 */
public class ParseMentorBoxLecture {
    public static void main(String[] args) {
        System.out.println("Hello");

        final String O_FILENAME = "/Users/nitin/OneDrive/Programming/Java/IntelliJ/mentorBox_lecture.txt";
        final String IN_FILENAME = "/Users/nitin/OneDrive/Programming/Java/IntelliJ/mentorBox_lecture.html";
        final String searchTitle = "        <a class='item' data-no-turbolink='true' href";

        Pattern pattern = Pattern.compile("        <a class='item' data-no-turbolink='true' href");


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
        String s = "";
        while (in.hasNext()) {
            String str = in.nextLine();
            s += str;
            if (str.contains(searchTitle)){
                output.println(str + "\t ||");
                System.out.println(str);
                titleCount++;
            }

 /*           if (str.equals(searchSubTitle)){
                output.println(in.nextLine());
                System.out.println(str);
                output.println("*******************");
                subTitleCount++;
            }*/

        }

        output.println("Total Titles found : " + titleCount);
        System.out.println("Total Titles found : " + titleCount);
        System.out.println("Total Subtitles found : " + subTitleCount);

        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            /*System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");*/
            /*System.out.println(matcher.group());*/
        }

        //Close the File
        in.close();
        output.close();
    }
}
