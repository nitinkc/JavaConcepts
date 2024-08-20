package nitin.multithreading.raceCondition.deadLocks;

public class IntersectionSync implements Intersection {
    private final Object northSouthLock = new Object();//Arbitrary object
    private final Object eastWestLock = new Object();

    @Override
    public void takeNorthSouthTrack() {
        synchronized (northSouthLock) {
             System.out.println("NorthSouthTrack is locked by thread " + Thread.currentThread().getName());
            synchronized (eastWestLock) {
                System.out.println("Train is passing through NorthSouthTrack");
                passingTrain();
            }
        }
    }

    @Override
    public void takeEastWestTrack() {
        synchronized (northSouthLock ) {//This will result in a deadlock. To avoid, keep the same sequence of Locks everywhere
            System.out.println("EastWestTrack is locked by thread " + Thread.currentThread().getName());
            synchronized (eastWestLock) {
                System.out.println("Train is passing through EastWestTrack");
                passingTrain();
            }
        }
    }

    @Override
    public void passingTrain() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}