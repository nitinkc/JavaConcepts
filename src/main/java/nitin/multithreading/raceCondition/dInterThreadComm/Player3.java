package nitin.multithreading.raceCondition.dInterThreadComm;

import java.util.Random;

public class Player3 extends Thread {

    I3NotifyAll notifyAllExample;
    Random rd = new Random();
    int totalscore;

    Player3(I3NotifyAll notifyAllExample) {
        this.notifyAllExample = notifyAllExample;
    }

    @Override
    public void run() {

        try {
            synchronized (notifyAllExample) {

                for (int i = 0; i < 100; i++) {

                    while (notifyAllExample.status != 3) {//Runs only when status is 1 or 2
                        notifyAllExample.wait();
                    }

                    System.out.print("C ");
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
        System.out.println("total score by c : " + totalscore);
    }
}
