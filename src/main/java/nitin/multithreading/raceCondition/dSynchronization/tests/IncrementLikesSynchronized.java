package nitin.multithreading.raceCondition.dSynchronization.tests;

import java.math.BigDecimal;

public class IncrementLikesSynchronized extends IncrementLikes {

    @Override
    public synchronized Integer incrementLikes() {
        return super.incrementLikes();
    }
}