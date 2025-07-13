package nitin.multithreading.raceCondition.dInterThreadComm;

import java.util.Random;

public class Player1 extends Thread {
    I3NotifyAll notifyAllExample;
    Random rd = new Random();
    int totalscore;

    Player1(I3NotifyAll notifyAllExample) {
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
        System.out.println("total score by a : " + totalscore);
    }
}
