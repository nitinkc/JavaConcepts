package nitin.virtualThreads;

import com.utilities.MultiThreadUtility;

import java.util.ArrayList;

public class V1Intro {
    public static void main(String[] args) throws InterruptedException {
        final int MAX_THREADS = 1_000_000;//One Million
        MultiThreadUtility.logShortMessage("Starting main");

        var threadList = new ArrayList<Thread>();
        for (var i = 1; i < MAX_THREADS; i++) {
            //createPlatformThread();
            threadList.add(createVirtualThread());
        }

        for (Thread thread : threadList) {
            thread.join();//Joining all of the threads so that the next set of instructions does not run until this is done.
        }
        MultiThreadUtility.delay(1000);
        MultiThreadUtility.logShortMessage("Ending main");

    }

    private static void createPlatformThread() {
        //The Virtual thread starts as a Daemon thread where as the platform thread starts as a non-daemon thread
        new Thread(Business::executeBusinessLogic).start();//JVM Can't handle large number threads with platform threads
    }

    private static Thread createVirtualThread() {
        //With Virtual threads, mounting and unmounting would happen so a thread is free to do tasks
        // Overhead of context switching is needed.
        return Thread.startVirtualThread(Business::executeBusinessLogic);
    }



}
