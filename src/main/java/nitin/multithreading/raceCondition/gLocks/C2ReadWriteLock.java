package nitin.multithreading.raceCondition.gLocks;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReadWriteLock;

import static com.utilities.MultiThreadUtility.logShortMessage;

/**
 * Created by Nitin C on 12/5/2015.
 * Modified on Aug 11 2024
 */

public class C2ReadWriteLock {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();
    private int value = 0;//Shared Resource

    public static void main(String[] args) {
        C2ReadWriteLock example = new C2ReadWriteLock();

        // Start write thread
        Thread writeThread = new Thread(() -> example.write(42));
        writeThread.setName("write-thread-1");
        writeThread.start();

        // Start read threads
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(example::read);
            thread.setName("read-thread-" + i);
            thread.start();
        }
    }

    public void read() {
        readLock.lock();
        try {
            // Perform read operations
            logShortMessage("Read value: " + value);
        } finally {
            readLock.unlock();
        }
    }

    public void write(int newValue) {
        writeLock.lock();
        try {
            // Perform write operations
            value = newValue;
            logShortMessage("Updated value to: " + value);
        } finally {
            writeLock.unlock();
        }
    }
}
