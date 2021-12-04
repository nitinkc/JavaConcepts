package java7.a13multithreadingEnhancements.cThreadPoolsAKAExecutorFW;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class aExecutorDemo {
    public static void main(String[] args) {
        PrintJobRunnable[] jobs = { // Creating runnable array
                new PrintJobRunnable("Clarks Summit"),
                new PrintJobRunnable("Scranton"),
                new PrintJobRunnable("GreenVille"),
                new PrintJobRunnable("Cary"),
                new PrintJobRunnable("New Jersey")
        };

        ExecutorService service = Executors.newFixedThreadPool(9);

        for (PrintJobRunnable job : jobs){
            service.submit(job);
        }
        service.shutdown();


    }
}
