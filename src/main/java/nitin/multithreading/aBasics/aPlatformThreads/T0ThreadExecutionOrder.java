package nitin.multithreading.aBasics.aPlatformThreads;

import static com.utilities.MultiThreadUtility.logMessage;

public class T0ThreadExecutionOrder {
    public static void main(String[] args) {
        // By default, the platform threads are NON-DAEMON Threads, unless it's explicitly marked
        // daemon.
        Thread thread1 = new Thread(() -> logMessage("1: I'm going for a walk"));
        Thread thread2 = new Thread(() -> logMessage("2: I'm going to swim"));

        thread1.start();
        thread2.start();

        logMessage("3: I'm going home");
    }
}
