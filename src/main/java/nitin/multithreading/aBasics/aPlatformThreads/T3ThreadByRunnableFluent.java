package nitin.multithreading.aBasics.aPlatformThreads;

import static com.utilities.MultiThreadUtility.logShortMessage;

public class T3ThreadByRunnableFluent {
    
    public static void main(String[] args) throws InterruptedException {

        logShortMessage("Starting Main Thread ..");

        // start a daemon thread using Fluent API
        Runnable r = new ThreadByRunnable();
        Thread thread = Thread.ofPlatform()
                .name("Simple")
                .daemon(true)
                .start(r);
        
        thread.join();//Forcing the main thread to stop for the child thread

        logShortMessage("Ending Main Thread ..");
    }
}
