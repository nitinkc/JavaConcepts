package nitin.io.interactingWithUsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Nitin C on 3/6/2016.
 */
public class OldBufferedReader {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a String");
        String input = null;
        try {
             input = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("You Entered " + input);

    }
}
