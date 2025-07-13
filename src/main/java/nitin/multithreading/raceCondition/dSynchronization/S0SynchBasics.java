package nitin.multithreading.raceCondition.dSynchronization;

/**
 * Created by Nitin Chaurasia on 12/6/15 at 6:14 PM.
 *
 * <p>Synchronize acquire Locks on the Object instance and not on the method. Thus If one Lock is
 * acquired by thread t1 for method m1, no other threads are allowed to execute even the non-sync
 * method m3.
 *
 * <p>The lock is specific to the instance of the class. If you have multiple instances of Basics,
 * each instance has its own lock. Synchronization only applies to methods on the same instance.
 *
 * <p>Non-Synchronized Methods: These methods do not acquire the same lock and can be executed
 * concurrently with synchronized methods or by other threads.\
 */
public class S0SynchBasics {
    public static void main(String[] args) throws InterruptedException {
        Basics basics = new Basics();

        Thread t1 =
                new Thread(
                        () -> {
                            System.out.println("Thread 1 started.");
                            basics.m1();
                            basics.m3();
                            System.out.println("Thread 1 finished.");
                        });

        Thread t2 =
                new Thread(
                        () -> {
                            System.out.println("Thread 2 started.");
                            basics.m2();
                            basics.m3();
                            System.out.println("Thread 2 finished.");
                        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
