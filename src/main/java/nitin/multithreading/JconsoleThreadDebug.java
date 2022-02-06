package nitin.multithreading;

import java.io.IOException;

/**
 * Created by Nitin Chaurasia on 12/5/15 at 6:06 PM.
 */
public class JconsoleThreadDebug {
    public static void main(String[] args) {
        DebugClass d = new DebugClass();
        Thread t = new Thread(d);
        t.setName("TEST THREAD");

        t.start();
    }
}


class DebugClass implements Runnable {
    @Override
    public void run() {
        System.out.println("-----Debugging starts------");
        //
        // Get Process Id

        //Turning on jconsole
        String command = "jconsole";
        Process p;

        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Sleep to see the results
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Quitting the thread" + Thread.currentThread());


    }
}
