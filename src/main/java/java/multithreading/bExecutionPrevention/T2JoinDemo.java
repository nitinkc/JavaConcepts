package java.multithreading.bExecutionPrevention;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 12:03 AM.
 *
 * Wait until the Completion of some other Thread
 *
 * Throws interruptedException (handle else compile error)
 */
public class T2JoinDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadJoin());
        Thread t2 = new Thread(new ThreadJoin());

        t1.start();

        // Main Thread (Calling Thread) Will wait until t1 Finishes
        // Output is deterministic
        try{
            t1.join();
        } catch (InterruptedException e){
            System.out.println(e.fillInStackTrace());
        }

        // If there is no join, BOTH Thread will be contending for CPU thus without
        // join() output is undeterministic
        for (int i = 0; i < 100; i++) {
            System.out.println("Main: " + i);
        }
    }
}

class ThreadJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Child : " + i);
//            try {
//                /Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
