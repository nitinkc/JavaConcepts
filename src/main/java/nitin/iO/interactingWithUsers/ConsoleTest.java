package nitin.iO.interactingWithUsers;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Nitin Chaurasia on 3/6/16 at 2:10 AM.
 *
 * Using Console to read input(usable only outside IDE)
 * System.console() returns null in an IDE
 * reader() and writer()
 * format() and printf()
 * flush() : forced any buffered output to be written immediately
 * readLine() :
 * readPassword() : like readLine BUT echoing is disabled. RETURNS a char ARRAY!!
 * Reading password : String values are kept in shared memory pool for performance reasons in java.
 * If the memory in application is ever dumped to the disk, the password could be recovered. Thus keep the
 * password in the char[] using the readPassword().
 */
public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console();

        if (console == null){
            // Not available in IDE's
            throw new RuntimeException("Console not available");
        } else {

            console.writer().print("Welcome to the Login System");
            console.flush();

            /**************** Reading a String name ***********************/
            String name = console.readLine("Please enter your name : ");

            /************** Reading an integer age ************************/
            Integer age = null;
            console.writer().print("What is your age? ");
            console.flush();

            BufferedReader reader = new BufferedReader(console.reader());
            String value = null;
            try {
                value = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            age = Integer.valueOf(value);
            console.writer().println();

            /*************Reading a password ************************/

            char[] password = console.readPassword("Enter your password ");

            console.format("Enter your password again: ");
            console.flush();
            char[] verify = console.readPassword();

            // Password Verification
            boolean match = Arrays.equals(password,verify);

            // Immediately clear password from memory
            for (int i = 0; i < password.length; i++) {
                password[i] = 'x';
                verify[i] = 'x';
            }

            console.format("Your Password was " + ( match ? "Correct" : "Incorrect"));

            // Printing out the read data
            console.format("Your name is " + name);
            console.writer().println();
            console.format("Your age is " + age);

            console.printf("Your password level is: " + password);

            String userInput = console.readLine();
            console.writer().println("You have entered from ..I did it so am recommending: " + userInput);
        }

    }
}
