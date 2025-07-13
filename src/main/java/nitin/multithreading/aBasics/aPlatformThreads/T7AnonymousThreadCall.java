package nitin.multithreading.aBasics.aPlatformThreads;

/**
 * Created by Nitin Chaurasia on 12/5/15 at 10:01 PM.
 *
 * <p>Calling the thread using the Anonymous Inner Class
 */
public class T7AnonymousThreadCall {
    public static void main(String[] args) {

        Thread t1 =
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 500; i++) {
                                    System.out.println(
                                            "From Thread 1: " + Thread.currentThread() + " " + i);
                                }
                            }
                        });

        Thread t2 =
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 500; i++) {
                                    System.out.println(
                                            "From Thread 2: " + Thread.currentThread() + " " + i);
                                }
                            }
                        });
        t1.start();
        t2.start();

        // The Main function continues
        for (int i = 0; i < 5; i++) {
            System.out.println("From Main: " + Thread.currentThread() + " " + i);
        }
    }
}
