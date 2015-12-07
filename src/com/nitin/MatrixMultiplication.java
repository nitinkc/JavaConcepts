//package com.nitin;
///**
// * Created by Nitin C on 12/7/2015.
// * Assignment Matrix Multiplication in Java
// */
//
//import com.sun.rowset.internal.Row;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class MatrixMultiplication {
//    /** GLOBAL VARIABLE DECLAARTION */
//
//    //Random Number Range
//    public final int MAXRAND = 99;
//
//    /* Declare number of Threads for Execution*/
//    int numThreads = 1;
//    //int chunk, threadId;
//
//    //Dimensions of the Matrices to be multiplied
//    public static final int ROW_A = 3;
//    public static final int COL_A = 3;
//    public static final int ROW_B = 3;
//    public static final int COL_B = 3;
//
//	/* Pointer for the three Matrix*/
//    static double matA[][] = new double[ROW_A][COL_A];
//    static double matB[][] = new double[ROW_B][COL_B];
//    static double matC[][] = new double[ROW_A][COL_B];
//
//    /* Variables for execution time*/
//    double begin=0, end=0;
//    double time_spent=0;
//
//    /* MAIN BEGINS */
//    public static void main(String[] args) {
//        /* TEMP : WELCOME MESSAGE AND ASKING FOR USER DEFINED NUMDER OF THREADS*/
//        System.out.println("=============================WELCOME============================\n");
//        System.out.println("            JAVA Multithreading Matrix Multiplication      \n");
//        System.out.println("================================================================\n\n");
////        System.out.println("Enter Number of Threads: ");
////        Scanner in = new Scanner(System.in);
////        int numThreads = in.nextInt();
////        in.close();//Close the input cxhannel
//        System.out.println("The number of threads are " + ROW_A*COL_B);
//
//        /* Check for multiplication compatibility */
//        if (COL_A != ROW_B){
//            System.out.println("Column for Matrix A should be same as that of Row for Matrix B\n");
//            System.out.println("Multiplication is not possible\n");
//            /* CAN USE USER DEFINED EXCEPTION AS WELL */
//            return; //used to control the untimely exit
//        }
//
//		/* Generate Random numbers and fill them in the Matrix*/
//        MatrixMultiplication mm = new MatrixMultiplication();
//        //mm.fillMatrix();
//
//        /* Multithreaded Multiplication*/
//
//        //Passing Different Objects
//
//        //All the multiplication can be performed independently
//        int total = ROW_A*COL_B;
//        Multiply m[] = new Multiply[total];
//        Thread t[] = new Thread[total];
//
//        double[] temp = new double[ROW_A*COL_B];
//        int index = 0;
//         /* Multithreaded Multiplication */
//        //for (int i = 0; i < ; i++) {
//
//        }
////        for(int i=0;i<ROW_A;i++){ //divided into equal size Chunks
////            for(int j=0;j<COL_B;j++){  //column of second matrix
////                temp[index++] = matA[i];
////                temp[index++] = matB[j];
////                m[i+j] = new Multiply(matA[i][j], matB[])
////                t[i+j].start();
////            }//end j
//        }//end i
//    }//Parallel block end
//
//        /* Output FILE HANDLING */
//        //mm.collectResults();
//
//    }//Main Ends here
//
//    void fillMatrix(){
//        int i,j,k;
//	/* Initialize the seed to generate Random Values */
//        Random generator = new Random(System.currentTimeMillis());
//
//	/* Generate Matrices*/
//        //Matrix A
//        for(i=0;i<ROW_A;i++){
//            for(j=0;j<COL_A;j++){
//                matA[i][j] = ((double)generator.nextInt(MAXRAND));
//            }//End Loop for Column
//        }//End Loop for Row
//
//        //Matrix B
//        for(i=0;i<ROW_B;i++){
//            for(j=0;j<COL_B;j++){
//                matB[i][j] = ((double)generator.nextInt(MAXRAND));
//            }//End Loop for Column
//        }//End Loop for Row
//
//        //Matrix C (initialized to Zero)
//        for(i=0;i<ROW_A;i++){
//            for(j=0;j<COL_B;j++){
//                matA[i][j] = ((double) 0);
//            }//End Loop for Column
//        }//End Loop for Row
//    }
//
//    /* For multithreaded threaded multiplication, Rows from matrix A is to be multiplied with Columns
//	 * of matrix B resulting in the Rows of Matrix C. Thus each thread can work on some Rows,
//	 * depending upon the division of jobs into threads
//	 * */
//
//    void multithreadedMultiplication() {
//        int i, j, k;
//        int this_thread, my_start, my_end;
//        begin = System.currentTimeMillis();
//    }
//
//
//
//    void collectResults(){
//        System.out.println("Execution time of Matrices of dim "+
//                ROW_A+"X" + COL_A+ " & " + ROW_B + " X " + COL_B +
//                "with "+ numThreads + " threads is " +  time_spent);
//    }
//}
//
//class Multiply implements Runnable{
//    @Override
//    public void run() {
//        multithreadedMultiplication();
//    }
//
//    private void multithreadedMultiplication{
//
//    }
//}