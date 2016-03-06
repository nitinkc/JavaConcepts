package com.nitin.concurrency.managingConcurrentProcess;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Nitin C on 3/5/2016.
 *
 * A CyclicBarrier takes in its constructor a limit value, indicating the number of threads to wait for
 * As each thread finishes, it calls the await() method on the CyclicBarrier. Once the specified number of threads
 * have each called await(), the barrier is released, and all the threads can continue
 *
 * DEADLOCK CONDITION: Set the available thread to be atleast as large as your Cyclic barrier limit value, else
 * the code will hang indefinitely. THE BARRIER WILL NEVER BE REACHED
 *
 * After the cyclic barrier is broken, all threads are released adn the number of threads waiting on the CyclicBarrier
 * goes back to 0. eg: # threads = 15, CyclicBarrier = 5; CyclicBarrier will be activated a total of 3 times
 */
public class M1CyclicBarriar {
    // Executing the database operation by 5 threads
    public static void main(String[] args) {
        ExecutorService executorService = null;
        try{
            executorService = Executors.newFixedThreadPool(5);
            DatabaseOperations databaseOperations = new DatabaseOperations();

            // Creating the barrier for more number of threads (eg 10 in this case) HALTS THE PROGRAM. DEADLOCK SITUATION
            CyclicBarrier c1 = new CyclicBarrier(5);
            CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("**** CONNECTION ESTBD ****"));

            for (int i = 0; i < 5; i++) {
                executorService.submit(() -> databaseOperations.performTask(c1,c2));
            }
        } finally {
            if (executorService != null)
                executorService.shutdown();
        }
    }
}

//Run all the database operation in parallel
class DatabaseOperations{
    public void performTask(CyclicBarrier c1, CyclicBarrier c2){
        try{//to be used for cyclic barrier
            getDriver();
            establishConnection();
            c1.await();
            prepareStatement();
            obtainResultSet();
            c2.await();
            closeConnection();
            // summary();
        } catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }

    }
    private void getDriver(){
        System.out.println("Open Driver using Driver Class by : " + Thread.currentThread());
    }

    private void establishConnection(){
        System.out.println("Establish Connection using Connection Class by : " + Thread.currentThread());
    }

    private void prepareStatement(){
        System.out.println("Prepare an SQL Statement to be executed on the DB Server by : " + Thread.currentThread());
    }

    private void obtainResultSet(){
        System.out.println("Obtain the data from the database by : " + Thread.currentThread());
    }

    private void closeConnection(){
        System.out.println("After obtaining the result, Close the connection by : " + Thread.currentThread());
    }

    private void summary(){
        System.out.println("By : "  + Thread.currentThread() +
                "\n1. Obtain DRIVER \n" +
                "2. Estb. CONNECTION \n" +
                "3. Write SQL STATEMENT \n" +
                "4. Obtain result in RESULTSET \n" +
                "5. Close the connection");
    }


}
