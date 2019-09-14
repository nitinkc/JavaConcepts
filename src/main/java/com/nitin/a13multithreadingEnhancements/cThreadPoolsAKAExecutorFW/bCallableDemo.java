package com.nitin.a13multithreadingEnhancements.cThreadPoolsAKAExecutorFW;

import java.util.concurrent.*;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class bCallableDemo {
    public static void main(String[] args) {
        PrintJobCallable[] jobs = {
                new PrintJobCallable(10),
                new PrintJobCallable(20),
                new PrintJobCallable(30),
                new PrintJobCallable(40),
                new PrintJobCallable(50),
                new PrintJobCallable(60)};

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (PrintJobCallable job: jobs) {
            Future f = service.submit(job);//To hold the return
            try {
                System.out.println("Return Value is : " + f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}
