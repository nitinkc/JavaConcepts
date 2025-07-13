package nitin.multithreading.aBasics.aPlatformThreads;

import com.utilities.MultiThreadUtility;

/**
 * Created by Nitin Chaurasia on 11/30/15 at 10:22 PM.
 *
 * <p>Demonstration that a Child Thread continues even if there is an exception in the Main Thread
 */
public class T1ThreadRunsParentDies { // by overriding run method
    static final int MAX = 50;

    // By default, the platform threads are NON-DAEMON Threads, unless its explicitly marked daemon.
    // If any non-daemon thread is running, the JVM WILL NOT shut it down even if the main thread
    // has terminated.
    public static void main(String[] args) throws InterruptedException {
        // Starting the Thread
        // By default, the platform threads are NON-DAEMON Threads, unless its explicitly marked
        // daemon.
        Thread thread = new Thread(() -> task(), "child");
        thread.setDaemon(
                false); // false=non-daemon, runs the child thread, even if the parent dies. if set
        // true, the child dies as soon as parent dies
        thread.start();

        // Deliberately putting and exception so that mainThread stops
        int test = 10 / 0;
        // Runtime Stack will be destroyed (for the main thread) as there is no exception handling
        // code

        thread.join();
    }

    private static void task() {
        int count = 1;

        for (int i = 1; i <= MAX; i++) {
            MultiThreadUtility.delay(100);
            System.out.println(Thread.currentThread() + " : Child Thread execution : " + i);
        }
    }
}
