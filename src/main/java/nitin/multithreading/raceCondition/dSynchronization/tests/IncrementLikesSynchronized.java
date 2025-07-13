package nitin.multithreading.raceCondition.dSynchronization.tests;

public class IncrementLikesSynchronized extends IncrementLikes {

    @Override
    public synchronized Integer incrementLikes() {
        return super.incrementLikes();
    }
}
