package nitin.multithreading.cVirtualThreads.v1Runnable;

import com.utilities.MultiThreadUtility;
import nitin.multithreading.cVirtualThreads.Business;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static nitin.multithreading.cVirtualThreads.Business.executeBusinessLogic;

public class V5VirtualThreadCreation {
    public static void main(String[] args) throws Exception {
        MultiThreadUtility.logMessage("Main starts");
        //createWithStaticMethod();
        //createWithVirtualBuilder();
        //createWithFactory();
        //createWithVirtualExecutorService();
        createWithThreadPerTaskExecutorService();
        MultiThreadUtility.logMessage("Main ends successfully");
    }

    /* Creates Virtual Threads using Static method Thread.ofVirtual() */
    private static void createWithStaticMethod() throws Exception {
        Thread t1 = Thread.ofVirtual().start(Business::executeBusinessLogic);//Can't be named
        Thread t2 = Thread.ofVirtual().start(Business::executeBusinessLogic);

        //Make sure that the thread terminates before moving on
        t1.join();
        t2.join();
    }

    /*  Creates Virtual Threads using a Virtual Builder.
     *  Builder is not Thread Safe
    */
    private static void createWithVirtualBuilder() throws Exception {
        Thread.Builder.OfVirtual ofVirtualBuilder = Thread.ofVirtual().name("my_virtual_thread",0);

        //Start the threads
        Thread t1 = ofVirtualBuilder.start(() -> executeBusinessLogic());
        Thread t2 = ofVirtualBuilder.start(() -> executeBusinessLogic());

        // Make sure the threads terminate
        t1.join(); t2.join();
    }

    /* Creates Virtual Threads using a Thread Factory. Thread Safe */
    private static void createWithFactory() throws Exception {

        // Create a Thread factory
        ThreadFactory threadfactory = Thread.ofVirtual().name("my_virtual_thread", 0).factory();

        // Start two virtual threads using the factory
        Thread t1 = threadfactory.newThread(() -> executeBusinessLogic());
        t1.start();

        Thread t2 = threadfactory.newThread(() -> executeBusinessLogic());
        t2.start();

        // Make sure the threads terminate
        t1.join();
        t2.join();

        // Proceed sequentially once the two virtual threads complete
    }

    /* Create a Virtual Thread using a Virtual Thread Executor */
    private static void createWithVirtualExecutorService() {
        // Create with Virtual Thread ExecutorService
        // try with resource will make sure all Virtual threads are terminated
        try (ExecutorService srv = Executors.newVirtualThreadPerTaskExecutor()) {
            // Submit two tasks to the Executor service
            srv.submit(() -> executeBusinessLogic());
            srv.submit(() -> executeBusinessLogic());
        }
    }


    /* Thread Per Task Executor Service */
    private static void createWithThreadPerTaskExecutorService() {
        // Create a Virtual Thread factory with custom name
        ThreadFactory threadFactory = Thread.ofVirtual().name("myThread", 0).factory();

        // Create a ExecutorService with newThreadPerTaskExecutor for this factory
        try (ExecutorService srv = Executors.newThreadPerTaskExecutor(threadFactory)) {
            // Submit two tasks to the Executor service
            srv.submit(() -> executeBusinessLogic());
            srv.submit(() -> executeBusinessLogic());
        }
    }
}