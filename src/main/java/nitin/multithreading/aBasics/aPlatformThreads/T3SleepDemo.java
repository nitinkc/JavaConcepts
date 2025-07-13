package nitin.multithreading.aBasics.aPlatformThreads;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 12:28 AM.
 *
 * <p>To just Pause
 */
public class T3SleepDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Line 1");

        // Sleep needs try catch or exception handling
        Thread.sleep(1000); // 1 sec, 1000 ms

        System.out.println("Line 2");
        Thread.sleep(2000);

        System.out.println("Line 3");
    }
}
