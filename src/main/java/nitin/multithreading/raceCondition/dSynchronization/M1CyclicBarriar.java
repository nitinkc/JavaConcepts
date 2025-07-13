package nitin.multithreading.raceCondition.dSynchronization;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Nitin C on 3/5/2016.
 *
 * <p>A CyclicBarrier takes in its constructor a limit value, indicating the number of threads to
 * wait for As each thread finishes, it calls the await() method on the CyclicBarrier. Once the
 * specified number of threads have each called await(), the barrier is released, and all the
 * threads can continue
 *
 * <p>DEADLOCK CONDITION: Set the available thread to be atleast as large as your Cyclic barrier
 * limit value, else the code will hang indefinitely. THE BARRIER WILL NEVER BE REACHED
 *
 * <p>After the cyclic barrier is broken, all threads are released adn the number of threads waiting
 * on the CyclicBarrier goes back to 0. eg: # threads = 15, CyclicBarrier = 5; CyclicBarrier will be
 * activated a total of 3 times
 */
public class M1CyclicBarriar {
    // Executing the database operation by 5 threads
    public static void main(String[] args) {
        DatabaseOperations databaseOperations = new DatabaseOperations();

        try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {

            // Creating the barrier for more number of threads (eg 10 in this case) HALTS THE
            // PROGRAM. DEADLOCK SITUATION
            CyclicBarrier c1 = new CyclicBarrier(5);
            CyclicBarrier c2 =
                    new CyclicBarrier(4, () -> System.out.println("**** CONNECTION ESTBD ****"));

            for (int i = 0; i < 1; i++) {
                executorService.submit(() -> databaseOperations.performTask(c1, c2));
            }
        }
    }
}
