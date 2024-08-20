package nitin.multithreading.raceCondition.dSynchronization;

import lombok.NoArgsConstructor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//Run all the database operation in parallel
@NoArgsConstructor
public class DatabaseOperations {
    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {//to be used for cyclic barrier
            getDriver();
            establishConnection();
            c1.await();
            prepareStatement();
            obtainResultSet();
            c2.await();
            closeConnection();
            // summary();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    private void getDriver() {
        System.out.println("Open Driver using Driver Class by : " + Thread.currentThread());
    }

    private void establishConnection() {
        System.out.println("Establish Connection using Connection Class by : " + Thread.currentThread());
    }

    private void prepareStatement() {
        System.out.println("Prepare an SQL Statement to be executed on the DB Server by : " + Thread.currentThread());
    }

    private void obtainResultSet() {
        System.out.println("Obtain the data from the database by : " + Thread.currentThread());
    }

    private void closeConnection() {
        System.out.println("After obtaining the result, Close the connection by : " + Thread.currentThread());
    }

    private void summary() {
        System.out.println("By : " + Thread.currentThread() +
                "\n1. Obtain DRIVER \n" +
                "2. Estb. CONNECTION \n" +
                "3. Write SQL STATEMENT \n" +
                "4. Obtain result in RESULTSET \n" +
                "5. Close the connection");
    }
}
