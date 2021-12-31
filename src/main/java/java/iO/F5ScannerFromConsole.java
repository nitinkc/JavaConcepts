package java.iO;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by nitin on 1/2/16.
 */
public class F5ScannerFromConsole {
    public static void main(String[] args) throws FileNotFoundException {
        /* READING THE DATA FROM CONSOLE */
        Scanner fromConsole = new Scanner(System.in);

        //Reading an integer
        System.out.print("Enter an Integer: ");
        int a = fromConsole.nextInt();
        System.out.println(a);

        //Reading a String
        System.out.print("Enter a String: ");
        String b = fromConsole.next();
        System.out.println(b);

        // Read a character
        System.out.print("Enter an Character: ");
        char c = fromConsole.next().charAt(0);//This is how Character is read
        System.out.println(c);

        // Read a character
        System.out.print("Enter an Double: ");
        double d = fromConsole.nextDouble();//This is how Character is read
        System.out.println(d);

    }
}
