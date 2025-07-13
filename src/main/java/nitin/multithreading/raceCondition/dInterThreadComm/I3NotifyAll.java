package nitin.multithreading.raceCondition.dInterThreadComm;

/** Created by Nitin Chaurasia on 12/4/15 at 1:32 AM. */
public class I3NotifyAll {
    // To control the Flow. Just by using Join it did not work
    int status = 1;

    public static void main(String[] args) throws InterruptedException {
        I3NotifyAll na = new I3NotifyAll();

        // Three threads acting on the same a5object
        Player1 a = new Player1(na);
        Player2 b = new Player2(na);
        Player3 c = new Player3(na);

        a.start();
        b.start();
        c.start();

        a.join();
        b.join();
        c.join();
    }
}
