package nitin.multithreading.raceCondition.eVolatileVar;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 6:31 AM.
 * Modified on Aug 12 2024
 */
public class R2Volatile {
    public static void main(String[] args) throws InterruptedException {
        VolatileTest c = new VolatileTest();
        Thread[] t = new Thread[20];
        for (int i = 0; i < 20; i++) {
            t[i] = new Thread(() -> c.task());
        }
        for (int i = 0; i < 20; i++) {
            t[i].setName("thread-"+i);
            t[i].start();
        }

        for (int i = 0; i < 20; i++) {
            t[i].join();
            // System.out.println("ss");
        }
    }
}