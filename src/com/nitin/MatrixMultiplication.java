package com.nitin;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by Nitin C on 12/7/2015.
 * Assignment Matrix Multiplication in Java
 */

public class MatrixMultiplication {
    /*GLOBAL VARIABLE DECLARATION */

    //Random Number Range
    public final int MAXRAND = 99;

    /* Declare number of Threads for Execution (Min 1 thread)*/
    static int numThreads = 1;

    //Dimensions of the Matrices to be multiplied
    public static final int ROW_A = 3;
    public static final int COL_A = 3;
    public static final int ROW_B = 3;
    public static final int COL_B = 3;

    /* Pointer for the three Matrix*/
    static double matA[][] = new double[ROW_A][COL_A];
    static double matB[][] = new double[ROW_B][COL_B];
    static double matC[][] = new double[ROW_A][COL_B];

    /* Variables for tracking time execution time*/
    static double begin = 0, end = 0;
    static double time_spent = 0;

    /* MAIN BEGINS */
    public static void main(String[] args) {
        /* FUTURE : WELCOME MESSAGE AND ASKING FOR USER DEFINED NUMDER OF THREADS*/
        System.out.println("=============================WELCOME============================");
        System.out.println("            JAVA Multithreading Matrix Multiplication           ");
        System.out.println("=============================================================== \n");

        //FUTURE: to be taken the count of thread by the user
//        System.out.println("Enter Number of Threads: ");
//        Scanner in = new Scanner(System.in);
//        int numThreads = in.nextInt();
//        in.close();//Close the input channel

        // Hardcoding the number of threads manually
        numThreads = ROW_A * COL_B;
        System.out.println("The number of threads are " + numThreads);

        /* Check for multiplication compatibility */
        if (COL_A != ROW_B) {
            System.out.println("Column for Matrix A should be same as that of Row for Matrix B\n");
            System.out.println("Multiplication is not possible\n");
            /* NEED TO LEARN: CAN USE USER DEFINED EXCEPTION AS WELL */
            return; //used to control the untimely exit
        }

		/* Generate Random numbers and fill them in the Matrix*/
        MatrixMultiplication mm = new MatrixMultiplication();

        //Fill the Matrices with Random Values
        /*FOR DEBUGGING: ALL VALUES IN MAT A are 3 and MAT B are 1*/
        mm.fillMatrix();

        //play with only one object to understand concurrency challenges
        Multiply m = new Multiply();
        Thread t[] = new Thread[numThreads];

        // Begin the counter for the execution time
        begin = System.currentTimeMillis();
         /* Multithreaded Multiplication */
        for (int i = 0; i < numThreads; i++) {
            t[i] = new Thread(m);
            t[i].start();
            t[i].setName("Thread#" + i);
        }

        /* After all the threads finishes execution
        Put the reults in the file : Output FILE HANDLING
        */

        // Wait till join()
        for (int i = 0; i < numThreads; i++) {
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // End the counter for the execution time
        end = System.currentTimeMillis();
        time_spent = end - begin;

        System.out.println("Execution time of Matrices of dim " +
                ROW_A + "X" + COL_A + " & " + ROW_B + "X" + COL_B +
                "with " + numThreads + " threads is " + time_spent);

        // Write the data inb the text file
        try {
            mm.collectResults();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-------------PROGRAM TERMINATES--------------");

    }//Main Ends here

    void fillMatrix() {
    /* Initialize the seed to generate Random Values */
        Random generator = new Random(System.currentTimeMillis());

	/* Generate Matrices*/
        //Matrix A
        for (int i = 0; i < ROW_A; i++) {
            for (int j = 0; j < COL_A; j++) {
                //matA[i][j] = ((double) generator.nextInt(MAXRAND));
                matA[i][j] = 3;
            }//End Loop for Column
        }//End Loop for Row

        //Matrix B
        for (int i = 0; i < ROW_B; i++) {
            for (int j = 0; j < COL_B; j++) {
                //matB[i][j] = ((double) generator.nextInt(MAXRAND));
                matB[i][j] = 1;
            }//End Loop for Column
        }//End Loop for Row

        //Matrix C (initialized to Zero)
        for (int i = 0; i < ROW_A; i++) {
            for (int j = 0; j < COL_B; j++) {
                matC[i][j] = ((double) 0);
            }//End Loop for Column
        }//End Loop for Row
    }//Fill Matrix Ends


    void collectResults() throws IOException {
        final String FILENAME = "nitin.txt";
        // Put MatA, MatB and MatC into a file to check if its returning the correct Result

        // Erasing files if already exist
        PrintWriter output = new PrintWriter(new FileWriter(FILENAME, false));

        /* Generate Matrices*/
        //Matrix A
        output.println("Matrix A: ");
        for (int i = 0; i < ROW_A; i++) {
            for (int j = 0; j < COL_A; j++) {
                output.print(matA[i][j] + " ");
            }//End Loop for Column
            output.println();//Change line
        }//End Loop for Row

        //Matrix B
        output.println("Matrix B: ");
        for (int i = 0; i < ROW_B; i++) {
            for (int j = 0; j < COL_B; j++) {
                output.print(matB[i][j] + " ");
            }//End Loop for Column
            output.println();//Change line
        }//End Loop for Row

        //Matrix C (initialized to Zero)
        output.println("Matrix C: ");
        for (int i = 0; i < ROW_A; i++) {
            for (int j = 0; j < COL_B; j++) {
                output.print(matC[i][j] + " ");
            }//End Loop for Column
            output.println();//Change line
        }//End Loop for Row

        // Does not write without flush
        output.flush();
        output.close();
    }
}

/* For multithreaded threaded multiplication, Rows from matrix A is to be multiplied with Columns
     * of matrix B resulting in the Rows of Matrix C. Thus each thread can work on some Rows,
	 * depending upon the division of jobs into threads
	 * */
class Multiply implements Runnable {
    @Override
    public void run() {
        // put the logic here
        MatrixMultiplication m = new MatrixMultiplication();

        /* The matrix multiplication Algorithm */
        for (int i = 0; i < m.ROW_A; i++) {
            for (int j = 0; j < m.COL_B; j++) {
                /*Let only one thread enter after this and do the work for one entry of the resultant matrix*/
                synchronized (m) {
                    for (int k = 0; k < m.COL_A; k++) {
                        /* KLUDGE: Something smells here: Correct output is not generated
                        The output is 3 times the real value,proving each entry is
                        acted upon by 3 threads. Problem can be solved by having only 3 threads, But
                         this was not the intended behaviour expected
                         */
                        m.matC[i][j] = m.matC[i][j] + (m.matA[i][k] * m.matB[k][j]);
                    }

                    // Console logging for the debugging
                    System.out.print("Operated by Thread : " + Thread.currentThread());
                    System.out.print(" --- Entry inserted at " + i + "" + j + " is :" + m.matC[i][j]);
                }
            }
            System.out.println();
        }
    }
}