package nitin.multithreading.aBasics.aPlatformThreads;

/** Created by Nitin Chaurasia on 12/2/15 at 10:08 PM. */
public class T2ThreadByOverridingStart {
    public static void main(String[] args) {
        MyThread t = new MyThread();

        // start is overridden thus it will execute like a normal method.
        t.start();
        t.run();
    }
}

class MyThread extends Thread {

    @Override
    // OverRiding start will make it execute like a normal method
    public void start() {
        System.out.println("OverRiding Start");
    }

    @Override
    public void run() {
        System.out.println("run Method");
    }
}
