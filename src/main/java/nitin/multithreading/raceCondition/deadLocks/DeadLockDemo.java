package nitin.multithreading.raceCondition.deadLocks;
import java.util.Random;


public class DeadLockDemo {
    /*
       =
       =
       =
=======X======
       =
       =
       =
 */
    public static void main(String[] args) {
        //Intersection intersection = new IntersectionSync();
        Intersection intersection = new IntersectionReentrantLocks();

        Thread trainAThread = new Thread(() -> new Train(intersection, true).run(), "TrainA");
        Thread trainBThread = new Thread(() -> new Train(intersection, false).run(), "TrainB");

        trainAThread.start();
        trainBThread.start();
    }
}