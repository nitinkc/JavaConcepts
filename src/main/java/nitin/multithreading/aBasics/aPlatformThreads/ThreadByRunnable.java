package nitin.multithreading.aBasics.aPlatformThreads;

/**
 * Created by Nitin Chaurasia on 12/2/15 at 11:44 PM.
 */
public class ThreadByRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }
}
