package java7.a12multithreading.cSynchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nitin Chaurasia on 12/5/15 at 10:09 PM.
 *
 * Smaller Synhronized Blocks
 */
public class S6ThreadPool {
    public static void main(String[] args) {

        //Keep a Pool of 10 workers. Submits as a batch of 10 threads
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //No need to create the instance of Thread class
        for(int i=0; i<50; i++) {
            executor.submit(new Workers(i));
        }

        executor.shutdown();

        System.out.println("All tasks submitted.");

        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
        }

        System.out.println("All tasks completed.");
        System.out.println();
    }

}

class Workers implements Runnable{
    private final int count;
    Workers(int i){
        this.count = i;
    }
    @Override
    public void run() {
        System.out.println("Starting... " + count);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending... " + count);
    }

    public int getCount(){
        return count;
    }

}
