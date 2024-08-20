package nitin.multithreading.raceCondition.dInterThreadComm;

import java.util.Random;

public class Player2 extends Thread {
    I3NotifyAll notifyAllExample;
    Random rd = new Random();
    int totalscore;

    Player2(I3NotifyAll notifyAllExample) {
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
        System.out.println("total score by b : " + totalscore);
    }

}
