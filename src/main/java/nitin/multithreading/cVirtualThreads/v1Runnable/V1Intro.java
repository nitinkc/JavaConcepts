package nitin.multithreading.cVirtualThreads.v1Runnable;

import com.utilities.MultiThreadUtility;
import nitin.multithreading.cVirtualThreads.Business;

import java.util.ArrayList;

public class V1Intro {
    final static int MAX_THREADS = 100_000;//One Million

    public static void main(String[] args) throws InterruptedException {
        MultiThreadUtility.logShortMessage("Starting main");

        platformThreads();
        //virtualThreads();

        MultiThreadUtility.delay(1000);
        MultiThreadUtility.logShortMessage("Ending main");

    }

    private static void platformThreads() throws InterruptedException {
        var threadList = new ArrayList<Thread>();
        for (var i = 1; i < MAX_THREADS; i++) {
            threadList.add(createPlatformThread());
        }

        for (Thread thread : threadList) {
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();//Joining all of the threads so that the next set of instructions does not run until this is done.
        }

    }

    private static void virtualThreads() throws InterruptedException {
        var threadList = new ArrayList<Thread>();
        for (var i = 1; i < MAX_THREADS; i++) {
            threadList.add(createVirtualThread());
        }

        for (Thread thread : threadList) {
            thread.join();//Joining all of the threads so that the next set of instructions does not run until this is done.
        }
    }

    private static Thread createPlatformThread() {
        //The Virtual thread starts as a Daemon thread where as the platform thread starts as a non-daemon thread
        return new Thread(Business::executeBusinessLogic);//JVM Can't handle large number threads with platform threads
    }

    private static Thread createVirtualThread() {
        //With Virtual threads, mounting and unmounting would happen so a thread is free to do tasks
        // Overhead of context switching is needed.
        return Thread.startVirtualThread(Business::executeBusinessLogic);
    }
}
