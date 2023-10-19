package nitin.virtualThreads;

import com.utilities.MultiThreadUtility;

public class V4 {
    public static void main(String[] args) {
        final int MAX_THREADS = 1000_000;//One Million

        //With Virtual threads, mounting and unmounting would happen so a thread is free to do tasks
        // Overhead of context switching is needed.
        for (var i = 0; i < MAX_THREADS; i++) {
            //new Thread(V0::doNothing).start();
            Thread.startVirtualThread(V4::doNothing);
        }

        MultiThreadUtility.delay(3000);
        System.out.println("DONE");

    }

    public static void doNothing(){
        //System.out.println(Thread.currentThread());
        MultiThreadUtility.delay(2000);//Sleeping for 2 secs
    }
}
