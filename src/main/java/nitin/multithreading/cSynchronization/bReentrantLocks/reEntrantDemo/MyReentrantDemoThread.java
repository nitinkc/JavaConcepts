package nitin.multithreading.cSynchronization.bReentrantLocks.reEntrantDemo;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class MyReentrantDemoThread extends Thread {

    Display d;
    String name;

    MyReentrantDemoThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.wishSynchronized(name);
        d.wishReentrantLocked(name);
    }
}
