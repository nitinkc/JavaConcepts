package nitin.multithreading.aBasics.aPlatformThreads;

/**
 * Created by Nitin Chaurasia on 12/2/15 at 10:30 PM.
 * <p>
 * This Method is Preferred to DEFINE A THREAD
 * <p>
 * We can extend other class while Implementing Runnable Interface
 */
public class T3ThreadByRunnable {
    public static void main(String[] args) {

        ThreadByRunnableDemo tbr = new ThreadByRunnableDemo();

        // Target Runnable
        Thread thread = new Thread(tbr);

        thread.start();

        //Normal Execution of main
        for (int i = 0; i < 100; i++) {
            System.out.println("From Main: " + i);
        }
    }
}


class ThreadByRunnableDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Child Thread: " + i);
        }
    }
}
