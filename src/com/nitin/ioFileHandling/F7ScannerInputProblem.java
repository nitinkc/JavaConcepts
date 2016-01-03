package com.nitin.ioFileHandling;

import java.util.Scanner;

/**
 * Created by nitin on 1/2/16.
 */
public class F7ScannerInputProblem {
    public static void main(String[] args) {

    /* Demonstration of Scanner input Problem (nextLine())caused by \n */

        Scanner fromConsole = new Scanner(System.in);

        //Reading a String
        System.out.print("Enter a String: ");
        //next will not pick up space separated values, thus nextLine is used
        String b = fromConsole.nextLine();

        //INPUT PROBLEM 1: To eat up the next string token (ONLY TO CONSUME EXTRA STRING TOKEN FROM NEXT!!)
        //fromConsole.next();// Replace by nextLine to solve the Problem

        System.out.println(b);


        //Reading an integer
        System.out.print("Enter an Integer: ");
        int a = fromConsole.nextInt();
        System.out.println(a);

        // Read a double. nextInd and nextDouble ignored the ENTER THAT IS PRESSED after inputting
        System.out.print("Enter an Double: ");
        double d = fromConsole.nextDouble();//This is how Character is read
        System.out.println(d);


        // INPUT PROBLEM 2: This statement is consuming the EXTRA ENTER (\n) that is given after imputing the double vlaue
        fromConsole.nextLine();// HAVE TO USE TO CONSUNE ANY LEADING/TRAILING \n

        //Reading a String
        System.out.print("Enter another String: ");
        String b1 = fromConsole.nextLine();
        System.out.println(b1);
    }

}
