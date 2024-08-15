package nitin.multithreading.raceCondition.semaphore;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

import static com.utilities.MultiThreadUtility.logShortMessage;

public class ProducerConsumer {
    private static final int QUEUE_CAPACITY = 10;
    private static Semaphore emptySemaphore = new Semaphore(QUEUE_CAPACITY);
    private static Semaphore fullSemaphore = new Semaphore(0);
    private static ReentrantLock lock = new ReentrantLock();
    private static Queue<Integer> queue = new LinkedList<>();

    public static void producerTask() {
        try {
            while (true) {
                emptySemaphore.acquire(); // Wait for an empty slot
                lock.lock(); // Lock access to the queue
                try {
                    int item = produceItem(); // Produce an item
                    queue.add(item); // Add item to the queue
                    logShortMessage("Produced: " + item);
                } finally {
                    lock.unlock(); // Release the lock
                }
                fullSemaphore.release(); // Signal that an item is available
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void consumerTask() {
        try {
            while (true) {
                fullSemaphore.acquire(); // Wait for an available item
                lock.lock(); // Lock access to the queue
                try {
                    int item = queue.remove(); // Remove item from the queue
                    logShortMessage("Consumed: " + item);
                    consumeItem(item); // Process the item
                } finally {
                    lock.unlock(); // Release the lock
                }
                emptySemaphore.release(); // Signal that an empty slot is available
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static int produceItem() {
        // Simulate producing an item
        return (int) (Math.random() * 100);
    }

    private static void consumeItem(int item) {
        // Simulate consuming an item
    }
}
