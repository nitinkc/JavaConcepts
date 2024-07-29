package nitin.multithreading.aBasics;

import java.util.concurrent.TimeUnit;

import static com.utilities.MultiThreadUtility.logShortMessage;

public class T3CreateByLambda {
    
    public static void main(String[] args) throws InterruptedException {
        logShortMessage("Starting Main Thread ..");

        Thread thread = Thread.ofPlatform().start(() -> {

            logShortMessage("Starting Simple Thread");

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

            logShortMessage("Ending Simple Thread");
        });

        thread.join();
        logShortMessage("Ending Main Thread ..");

    }

}

