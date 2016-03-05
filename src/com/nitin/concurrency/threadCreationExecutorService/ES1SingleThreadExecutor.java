package main.java.com.nitin.concurrency.threadCreationExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Nitin C on 3/3/2016.
 * Concurrency API includes the Executors factory class that can
 * be used to create instances of the ExecutorServiceObject
 *
 * Tasks are guaranteed to be executed int he order they are submitted for a single-threaded application
 */
public class ES1SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            System.out.println("BEGIN");
            //execute needs runnable
            // fire and forget method
            service.execute(() -> System.out.println("One little lambda function for the thread"));
            service.execute(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Printing : " + i);
                }
            });
            System.out.println("END");
        }
        finally {
            // A thread executor creates anon-daemon thread on the first task taht is executed, so failing to call
            // shutdown() will result in your application never terminating
            // shutdownNow() attempts to stop all running thread
            if (service != null)
                service.shutdown();
        }
    }
}