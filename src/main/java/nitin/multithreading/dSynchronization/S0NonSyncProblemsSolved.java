package nitin.multithreading.dSynchronization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 3/25/18 at 1:07 AM.
 */
public class S0NonSyncProblemsSolved {
    private static int counter = 0;//Common Resource
    static ArrayList<Integer> counterValues = new ArrayList<>();
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> processThreads = createThreads(100);//100 threads

        //Start all threads
        for(Thread thread : processThreads)
            thread.start();

        //Wait for all the threads to be over
        for(Thread thread : processThreads)
            thread.join();

        System.out.println("Finished execution : " + counterValues.size());//Does not guarantee correct result each time
        System.out.println(counterValues);
    }

    public static List<Thread> createThreads(int numberOfThreads) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread t1 = new Thread(S0NonSyncProblemsSolved::counter);
            threads.add(t1);
        }
        return threads;
    }

    //Forcing only one thread at a time. Expensive operation
    public static void counter() {
        synchronized (lock){
            ++counter;
            counterValues.add(counter);
        }
        //counterValues.add(counter);////Does not guarantee correct result each time
    }
}
