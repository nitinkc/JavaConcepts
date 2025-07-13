package nitin.multithreading.aBasics.aPlatformThreads;

import static com.utilities.MultiThreadUtility.logShortMessage;

import java.util.concurrent.TimeUnit;

public class T5CreateByMethodReference {

    public static void main(String[] args) {

        logShortMessage("Starting Main Thread ..");
        Thread thr = new Thread(T5CreateByMethodReference::doSomething);
        thr.start();
        logShortMessage("Ending Main Thread ..");
    }

    public static void doSomething() {

        logShortMessage("Starting Simple Thread");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        logShortMessage("Ending Simple Thread");
    }
}
