package nitin.multithreading.dSynchronization.bankingDemo;

/**
 * Created by Nitin C on 12/8/2015.
 */
public class B0NeedForSynchronization {
    public static void main(String[] args) {
        //To demonstrate Concurrency ont one a5object is acted upon
        FinTrans ft = new FinTrans();
        TransThread tt1 = new TransThread(ft, "Deposit Thread");
        TransThread tt2 = new TransThread(ft, "Withdrawal Thread");
        tt1.start();
        tt2.start();
    }
}

class FinTrans {
    public static String transName;
    public static double amount;
}

class TransThread extends Thread {
    private final FinTrans ft;

    TransThread(FinTrans ft, String name) {
        super(name); // Save thread's name
        this.ft = ft; // Save reference to financial transaction a5object
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (getName().equals("Deposit Thread")) {
                // Start of deposit thread's critical code section

                //CAN USE SYNCHRONIZED BLOCK, BUT WILL BE SERIOUSLY SLOW
                //The same block can be written in a synchronized method
                //synchronized (ft){
                FinTrans.transName = "Deposit";
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                }
                //Deposit should always be 2000
                FinTrans.amount = 2000.0;
                System.out.println(FinTrans.transName + " " + FinTrans.amount);
                //}//End Sync

                // End of deposit thread's critical code section
            } else {
                // Start of withdrawal thread's critical code section
                //CAN USE SYNCHRONIZED BLOCK, BUT WILL BE SERIOUSLY SLOW
                //synchronized (ft){
                FinTrans.transName = "Withdrawal";
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                }
                FinTrans.amount = 250.0;
                System.out.println(FinTrans.transName + " " + FinTrans.amount);
                //}//End Sync

                // End of withdrawal thread's critical code section
            }
        }
    }
}