package java7.a12multithreading.eVolatileVar;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 6:31 AM.
 */
public class R2Volatile {
    public static void main(String[] args) {
        VolatileTest c = new VolatileTest();
        Thread[] t = new Thread[20];
        for (int i = 0; i < 20; i++) {
            t[i] = new Thread(c);
        }
        for (int i = 0; i < 20; i++) {
            t[i].start();
            // System.out.println("ss");
        }
    }
}


class VolatileTest implements Runnable {

    /* volatile variable will be read from the computer's main memory,  and not from the CPU cache.
    Every write to a volatile variable will be written to main memory, and not just to the CPU cache.
    * */
    public volatile int counter = 0;

    int j = 0;// Normal Variable, read from CPU Cache
    volatile int v = 0; // Volatile variable, read from Main Memory

    @Override
    public void run() {
        int i = 0;
        while (j < 10) {
            try {

                int local = 0;
                local++;
                //System.out.println(local + " local" + Thread.currentThread());
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Search atomic
            System.out.println(" read j: " + j + "\t v:" + v + "\t" +
                    "write ++ j : " + ++j + "\t ++v:" + ++v + "\t"+Thread.currentThread());
        }
    }
}