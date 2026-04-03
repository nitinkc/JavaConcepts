package nitin.multithreading.aBasics.executionPrevention;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 12:57 AM.
 *
 * <p>A Thread Can Interrupt another Sleeping or Waiting Thread
 */
public class T3InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Lazy Child: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                        System.out.println("I am Interrupted : Child thread " + Thread.currentThread().getName());
                        e.printStackTrace();
                }
            }
        });

        t.start();

        // No impact if target thread is in NOT in sleeping or Waiting state
        t.interrupt();

        // Normal Main Execution
        for (int i = 0; i < 100; i++) {
            System.out.println("Main: " + i + " :: " + Thread.currentThread().getName() );
        }
    }
}
