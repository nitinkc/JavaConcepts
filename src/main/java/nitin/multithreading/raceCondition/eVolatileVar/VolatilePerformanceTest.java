package nitin.multithreading.raceCondition.eVolatileVar;

public class VolatilePerformanceTest {
    // Volatile and non-volatile variables
    private volatile int volatileCounter = 0;
    private int nonVolatileCounter = 0;

    public static void main(String[] args) {
        // Create instances for testing
        VolatilePerformanceTest test = new VolatilePerformanceTest();

        // Run performance tests
        test.testVolatileReadWrite();
        test.testNonVolatileReadWrite();
    }

    // Test performance for volatile variable
    public void testVolatileReadWrite() {
        final int NUM_THREADS = 4;
        final int NUM_ITERATIONS = 1000000;

        // Create and start threads for volatile variable test
        Thread[] threads = new Thread[NUM_THREADS];
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < NUM_ITERATIONS; j++) {
                    volatileCounter++; // Write
                    volatileCounter--; // Read
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Volatile Read/Write Time: " + (endTime - startTime) + " nanoseconds");
    }

    // Test performance for non-volatile variable
    public void testNonVolatileReadWrite() {
        final int NUM_THREADS = 4;
        final int NUM_ITERATIONS = 1000000;

        // Create and start threads for non-volatile variable test
        Thread[] threads = new Thread[NUM_THREADS];
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < NUM_ITERATIONS; j++) {
                    nonVolatileCounter++; // Write
                    nonVolatileCounter--; // Read
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Non-Volatile Read/Write Time: " + (endTime - startTime) + " nanoseconds");
    }
}