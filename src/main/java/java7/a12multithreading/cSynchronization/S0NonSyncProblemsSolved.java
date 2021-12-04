package java7.a12multithreading.cSynchronization;

import java.util.ArrayList;

/**
 * Created by Nitin Chaurasia on 3/25/18 at 1:07 AM.
 */
public class S0NonSyncProblemsSolved {
    private static int counter = 0;

    public static synchronized void counter(){
        ++counter;
    }

    public static void main(String[] args) {

        ArrayList<Integer> counterValues = new ArrayList<>();

//        for (int i = 0; i < 10000; i++) {
//            process();
//            counterValues.add(counter);
//        }

        process();
        counterValues.add(counter);

        System.out.println("Finished execution");
        System.out.println(counterValues);
    }

    public static void process(){
        //counter =0;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
