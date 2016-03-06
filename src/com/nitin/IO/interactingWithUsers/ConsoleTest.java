package com.nitin.IO.interactingWithUsers;

import java.io.Console;

/**
 * Created by Nitin Chaurasia on 3/6/16 at 2:10 AM.
 */
public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console();
        if(console != null) {
            String userInput = console.readLine();
            console.writer().println("You have entered from ..I did it so am recommending: " + userInput);
        }

    }
}
