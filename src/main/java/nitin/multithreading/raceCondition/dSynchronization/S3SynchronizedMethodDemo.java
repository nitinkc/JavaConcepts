package nitin.multithreading.raceCondition.dSynchronization;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 10:29 PM.
 */
public class S3SynchronizedMethodDemo {
    public static void main(String[] args) {
        Display d1 = new Display();

        // Concurrency happens when a same Object is being acted upon
        Thread t1 = new MyThread(d1, "Thread1");
        Thread t2 = new MyThread(d1, "Thread2");

//        t1.start();
//        t2.start();

        caseStudy1();
    }

    /**
     * WHENEVER MULTIPLE THREADS ARE OPERATING ON SAME OBJECT, THEN ONLY SYNCHRONIZATION
     * PLAYS A ROLE. IF THERE ARE TWO DIFFERENT OBJECTS ACCESSED bY TWO DIFFERENT THREADS
     * THSRE IS NO ROLE OF SYNCHRONIZATION.
     */
    private static void caseStudy1() {
        Display d1 = new Display();
        Display d2 = new Display();

        MyThread t1 = new MyThread(d1, "CS1");
        MyThread t2 = new MyThread(d2, "CS2");

        // Irregular outputs because the threads are operating on different objects
        t1.start();
        t2.start();
    }
}

class Display {

    //If the synchronized method does not allow two simultaneous threads to execute
    // TRY: remove the synchronized keyword and see the effects;
    public synchronized void wish(String name) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.print("Hello - " + i);
            Thread.sleep(500);
            System.out.println(" - " + name);
        }
    }
}

class MyThread extends Thread {
    Display d;
    String name;

    // Constructor
    MyThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            d.wish(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
