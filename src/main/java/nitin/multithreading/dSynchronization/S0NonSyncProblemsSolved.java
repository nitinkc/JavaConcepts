package nitin.multithreading.dSynchronization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 3/25/18 at 1:07 AM.
 */
public class S0NonSyncProblemsSolved {
    private static int counter = 0;//Common Resource

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> counterValues = new ArrayList<>();
        List<Thread> processThreads = process();

        //Wait for all the threads to be over
        for(Thread thread : processThreads)
            thread.join();

        counterValues.add(counter);

        System.out.println("Finished execution");
        System.out.println(counterValues);
    }

    public static List<Thread> process() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(S0NonSyncProblemsSolved::task);
            t1.start();
            threads.add(t1);
        }
        return threads;
    }

    private static void task() {
        for (int i = 0; i < 100; i++) {
            counter();
        }
    }

    //Forcing only one thread at a time. Expensive operation
    public static synchronized void counter() {
        ++counter;
    }
}
