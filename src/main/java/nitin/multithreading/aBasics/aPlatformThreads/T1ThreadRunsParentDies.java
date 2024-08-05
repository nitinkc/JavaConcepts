package nitin.multithreading.aBasics.aPlatformThreads;

import com.utilities.MultiThreadUtility;

/**
 * Created by Nitin Chaurasia on 11/30/15 at 10:22 PM.
 *
 * Demonstration that a Child Thread continues even if there is an exception in the Main Thread
 */
public class T1ThreadRunsParentDies {// by overriding run method
    static final int MAX = 50;

    //By default, the platform threadsa re NON-DAEMON Threads, unless its explicitly marked daemon.
    // If any non daemon thread is running, the JVM will not shut it down even if the main thread has terminated.
    public static void main(String[] args) throws InterruptedException {
        //Starting the Thread
        //By default, the platform threads are NON-DAEMON Threads, unless its explicitly marked daemon.
        Thread thread = new Thread(T1ThreadRunsParentDies::task);
        thread.setName("child");
        thread.start();

        //Deliberately putting and exception so that main stops
        int test = 10 / 0;
        // Runtime Stack will be destroyed as there is no exception handling code

        for (int i = 1; i <= MAX; i++) {
            System.out.println("Main Thread execution" + i);
        }

        thread.join();
    }

    private static void task() {
        int count = 1;

        for (int i = 1; i <= MAX; i++) {
            MultiThreadUtility.delay(100);
            System.out.println(STR."\{Thread.currentThread()} : Child Thread execution : \{i}");
        }
    }
}
