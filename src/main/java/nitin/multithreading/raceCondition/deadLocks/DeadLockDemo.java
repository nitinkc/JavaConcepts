package nitin.multithreading.raceCondition.deadLocks;

import java.io.IOException;

public class DeadLockDemo {
    /*
           =
           =
           =
    =======X=======
           =
           =
           =
     */
    public static void main(String[] args) {
        // Intersection intersection = new IntersectionSync();
        Intersection intersection = new IntersectionReentrantLocks();

        Thread trainAThread = new Thread(() -> new Train(intersection, true).run(), "TrainA");
        Thread trainBThread = new Thread(() -> new Train(intersection, false).run(), "TrainB");

        trainAThread.start();
        trainBThread.start();

        String command = "jconsole";
        Process p;

        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Sleep to see the results
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}