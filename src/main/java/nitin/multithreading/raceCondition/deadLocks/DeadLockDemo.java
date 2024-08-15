package nitin.multithreading.raceCondition.deadLocks;
import java.util.Random;

public class DeadLockDemo {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();

        Thread trainAThread = new Thread(() -> new Train(intersection, true).run());
        Thread trainBThread = new Thread(() -> new Train(intersection, false).run());

        trainAThread.setName("TrainA");
        trainBThread.setName("TrainB");
        trainAThread.start();
        trainBThread.start();
    }

    public static class Train {
        private final Intersection intersection;
        private final boolean useRoadA;
        private final Random random = new Random();

        public Train(Intersection intersection, boolean useRoadA) {
            this.intersection = intersection;
            this.useRoadA = useRoadA;
        }

        public void run() {
            while (true) {
                sleepRandomTime();
                if (useRoadA) {
                    intersection.takeRoadA();
                } else {
                    intersection.takeRoadB();
                }
            }
        }

        private void sleepRandomTime() {
            try {
                Thread.sleep(random.nextInt(5));
                //Thread.sleep(10000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
    }

    public static class Intersection {
        private final Object roadA = new Object();
        private final Object roadB = new Object();

        public void takeRoadA() {
            synchronized (roadA) {
                System.out.println("Road A is locked by thread " + Thread.currentThread().getName());
                synchronized (roadB) {
                    System.out.println("Train is passing through road A");
                    sleepBriefly();
                }
            }
        }

        public void takeRoadB() {
            synchronized (roadB) {
                System.out.println("Road B is locked by thread " + Thread.currentThread().getName());
                synchronized (roadA) {
                    System.out.println("Train is passing through road B");
                    sleepBriefly();
                }
            }
        }

        private void sleepBriefly() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
    }
}