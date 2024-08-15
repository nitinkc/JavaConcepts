package nitin.multithreading.raceCondition.dInterThreadComm;

import java.util.Random;

/**
 * Created by Nitin Chaurasia on 12/4/15 at 1:32 AM.
 */
public class I3NotifyAll {

    //To control the Flow. Just by using Join it did not work
    int status = 1;

    public static void main(String[] args) {

        I3NotifyAll na = new I3NotifyAll();

        // Three threads acting on the same a5object
        A1 a = new A1(na);
        B1 b = new B1(na);
        C1 c = new C1(na);

        a.start();
        b.start();
        c.start();
    }
}

class B1 extends Thread {

    I3NotifyAll notifyAllExample;
    Random rd = new Random();
    int totalscore;

    B1(I3NotifyAll notifyAllExample) {
        this.notifyAllExample = notifyAllExample;
    }

    @Override
    public void run() {

        try {
            synchronized (notifyAllExample) {

                for (int i = 0; i < 100; i++) {

                    while (notifyAllExample.status != 2) {
                        notifyAllExample.wait();  // wait and notify method are from object class
                        // sleep method is from thread class
                        // sleep method never releases the lock
                    }

                    System.out.print("B ");
                    // System.out.print("b is playing   ");
                    // System.out.print("throwing dice");
                    int score = rd.nextInt(6);
                    System.out.print(score + "; ");
                    totalscore = totalscore + score;
                    notifyAllExample.status = 3;
                    notifyAllExample.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception 2 :" + e.getMessage());
        }
        System.out.println(totalscore + "total score by b");
    }

}

class C1 extends Thread {

    I3NotifyAll notifyAllExample;
    Random rd = new Random();
    int totalscore;

    C1(I3NotifyAll notifyAllExample) {
        this.notifyAllExample = notifyAllExample;
    }

    @Override
    public void run() {

        try {
            synchronized (notifyAllExample) {

                for (int i = 0; i < 100; i++) {

                    while (notifyAllExample.status != 3) {
                        notifyAllExample.wait();
                    }

                    System.out.print("C ");
                    // System.out.print("c is playing   ");
                    // System.out.print("throwing dice");
                    int score = rd.nextInt(6);
                    System.out.println(score + "; ");
                    totalscore = totalscore + score;
                    notifyAllExample.status = 1;
                    notifyAllExample.notifyAll();
                }

            }
        } catch (Exception e) {
            System.out.println("Exception 3 :" + e.getMessage());
        }
        System.out.println(totalscore + "total score by c");
    }
}

class A1 extends Thread {
    I3NotifyAll notifyAllExample;
    Random rd = new Random();
    int totalscore;

    A1(I3NotifyAll notifyAllExample) {
        this.notifyAllExample = notifyAllExample;
    }

    @Override
    public void run() {

        try {
            synchronized (notifyAllExample) {

                for (int i = 0; i < 100; i++) {

                    while (notifyAllExample.status != 1) {
                        notifyAllExample.wait();
                    }

                    System.out.print("A  ");
                    // System.out.print("throwing dice");
                    int score = rd.nextInt(6);
                    System.out.print(score + "; ");
                    totalscore = totalscore + score;
                    notifyAllExample.status = 2;
                    notifyAllExample.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception 1 :" + e.getMessage());
        }
        System.out.println(totalscore + "total score by a");
    }
}
