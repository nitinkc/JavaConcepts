package nitin.multithreading.dSynchronization;

import java.util.ArrayList;

/**
 * Created by Nitin Chaurasia on 3/25/18 at 12:58 AM.
 * <p>
 * Demo that the value of a counter is not incremented properly
 */
public class S0NonSyncProblems {
    private static int counter = 0;

    public static void main(String[] args) {
        ArrayList<Integer> counterValues = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            process();
            counterValues.add(counter);
        }

        System.out.println("Finished execution");
        System.out.println(counterValues);
    }

    public static void process() {
        counter = 0;
        Thread t1 = new Thread(S0NonSyncProblems::task);
        Thread t2 = new Thread(S0NonSyncProblems::task);

        t1.start();
        t2.start();
    }

    private static void task() {
        for (int i = 0; i < 10000; i++) {
            ++counter;
        }
    }
}


