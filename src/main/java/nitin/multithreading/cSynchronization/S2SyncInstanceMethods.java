package nitin.multithreading.cSynchronization;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 6:02 AM.
 */
public class S2SyncInstanceMethods {
    public static void main(String[] args) throws InterruptedException {
        Worker w = new Worker();
        Thread[] t = new Thread[10];

        long start = System.currentTimeMillis();

        //10 Threads operating concurrently on a same object
        for (int i = 0; i < 10; i++) {
            t[i] = new Thread(w);
            t[i].start();
        }

        // If join is not used, main thread will continue executing and count would be 0;
        // Thus wait here untill all the threads are done and then execute the sout w.count
        for (int i = 0; i < 10; i++) {
            t[i].join();// Throws Interrupted Exception
        }
        long end = System.currentTimeMillis();

        System.out.println("The total Count is:" + w.count);
        System.out.println("Total Time in Execution: " + (end-start));
    }
}

class Worker implements Runnable{
    //Variable residing in the Heap, shared among all the threads
    int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            // This is problamatic because concurrent executions may drop some changes
            //count++;
            count();
        }
    }

    //Synchronize will make sure that the value of count is always accessed by only one thread at once
    // This will increase the time of execution
    // Not using suync will decrease the reliability of the results.
    private  void count() {
        count++;
    }
}
