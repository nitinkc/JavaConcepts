package nitin.multithreading.raceCondition.eVolatileVar;

public class VolatileTest {

    /* volatile variable will be read from the computer's main memory,  and not from the CPU cache.
    Every write to a volatile variable will be written to main memory, and not just to the CPU cache.
    * */
    public volatile int counter = 0;

    int classLevelVar = 0; // Normal Variable, read from CPU Cache
    volatile int v = 0; // Volatile variable, read from Main Memory

    public void task() {
        int i = 0;
        while (classLevelVar < 10) {
            try {
                int local = 0; // Each thread reads and maintains its local copy
                local++;
                System.out.println(local + " local" + Thread.currentThread());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Search atomic
            System.out.println(
                    " read classLevelVar: "
                            + classLevelVar
                            + "\t v:"
                            + v
                            + "\t"
                            + "write ++classLevelVar : "
                            + ++classLevelVar
                            + "\t ++v:"
                            + ++v
                            + "\t"
                            + Thread.currentThread());
        }
    }
}
