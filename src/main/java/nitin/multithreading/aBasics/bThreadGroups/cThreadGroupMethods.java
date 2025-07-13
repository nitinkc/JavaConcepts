package nitin.multithreading.aBasics.bThreadGroups;

/** Created by nitin.chaurasia on 12/25/2016. */
public class cThreadGroupMethods {
    public static void main(String[] args) {
        ThreadGroup pg = new ThreadGroup("Parent Group");
        ThreadGroup cg = new ThreadGroup("Child Group");

        MyThread t1 = new MyThread(pg, "ChildThread1");
        MyThread t2 = new MyThread(pg, "ChildThread2");

        // Start the Thread
        t1.start();
        t2.start();

        System.out.println(pg.activeCount()); // 2
        System.out.println(pg.activeGroupCount()); // 1

        pg.list();

        try { // After 10 secs, both active threads will be gone as 5000 is the sleep time for
            // MyReentrantDemoThread
            Thread.sleep(1000); // have to use try catch
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(pg.activeCount()); // 0
        System.out.println(pg.activeGroupCount()); // 1

        pg.list();
    }
}
