package nitin.multithreading.raceCondition.deadLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntersectionReentrantLocks implements Intersection{
        private final Lock northSouthLock = new ReentrantLock();
        private final Lock eastWestLock = new ReentrantLock();

        @Override
        public void takeNorthSouthTrack() {
            // Acquire locks in a consistent order to avoid deadlock
            northSouthLock.lock();
            try {
                System.out.println("NorthSouthTrack is GREEN : " + Thread.currentThread().getName());
                eastWestLock.lock();
                try {
                    System.out.println("Train is passing through NorthSouthTrack");
                    passingTrain();
                } finally {
                    eastWestLock.unlock();
                }
            } finally {
                northSouthLock.unlock();
            }
        }

        @Override
        public void takeEastWestTrack() {
            // Acquire locks in a consistent order to avoid deadlock
            eastWestLock.lock();//Still deadlocks
            try {
                System.out.println("EastWestTrack is GREEN " + Thread.currentThread().getName());
                northSouthLock.lock();
                try {
                    System.out.println("Train is passing through EastWestTrack");
                    passingTrain();
                } finally {
                    northSouthLock.unlock();
                }
            } finally {
                eastWestLock.unlock();
            }
        }

    @Override
    public void passingTrain() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}