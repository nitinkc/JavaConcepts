package nitin.multithreading.raceCondition.dSynchronization;

import com.utilities.MultiThreadUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nitin Chaurasia on 3/25/18 at 12:58 AM.
 * Demo that the value of a counter is not incremented properly
 */
public class S0NonSyncProblems {
    private static int counter = 0;//Shared Variable
    static ArrayList<Integer> counterValues = new ArrayList<>(100);

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();;

        for (int i = 0; i < 100; i++) {
            //100 threads trying to fill values in the array
            Thread t1 = new Thread(S0NonSyncProblems::task);
            t1.setName(STR."thread:\{i}");
            threads.add(t1);
        }

        for(Thread thread : threads){
            thread.start();
        }

        for(Thread thread : threads){
            thread.join();
        }

        System.out.println("Finished execution : " + counterValues.size());
        //System.out.println(counterValues);
    }

    private static void task() {
        MultiThreadUtility.delay(new Random().nextInt(1000));//Random delay
        counterValues.add(++counter);
    }
}