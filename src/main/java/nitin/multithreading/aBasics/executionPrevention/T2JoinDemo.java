package nitin.multithreading.aBasics.executionPrevention;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 12:03 AM.
 *
 * <p>Wait until the Completion of some other Thread
 *
 * <p>Throws interruptedException (handle else compile error)
 */
public class T2JoinDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Child: " + i + "\t Thread: " + Thread.currentThread().getName());
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        // Main Thread (Calling Thread) Will wait until t1 Finishes
        // Output is deterministic
        //t1.join();

        // If there is no join, BOTH Thread will be contending for CPU thus without
        // join() output is undeterministic
        for (int i = 0; i < 10; i++) {
            System.out.print("Main: " + i + "\t");
        }
    }
}