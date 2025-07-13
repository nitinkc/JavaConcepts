package nitin.multithreading.raceCondition.deadLocks;

public interface Intersection {
    public void takeNorthSouthTrack();

    public void takeEastWestTrack();

    public void passingTrain();
}
