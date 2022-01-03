package nitin.iO.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Nitin C on 3/6/2016.
 *
 * markSupported() : not all java io input stream classes support this operation
 */
public class S1InputStream {
    public static void main(String[] args) {

        // Opening the Stream to the File names nitin.txt kept in home directory
        InputStream inputstream = null;
        try {
            inputstream = new FileInputStream("nitin.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Reading the stream
        try {
            //Reads the forst charactr of the file.
            System.out.println((char)inputstream.read());
            // If no type casting, the return ASCII int nunmber
            System.out.println(inputstream.read());

            if (inputstream.markSupported()){
                inputstream.mark(100); //Calling mark with read ahead limit
                System.out.println((char)inputstream.read());
                inputstream.skip(2);
                System.out.println(inputstream.read());
                inputstream.reset();//resets to an earlier state

            } else{
                System.out.println("Mark not supported");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
