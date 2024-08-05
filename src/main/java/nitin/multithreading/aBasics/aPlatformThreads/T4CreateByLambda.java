package nitin.multithreading.aBasics.aPlatformThreads;

import static com.utilities.MultiThreadUtility.logShortMessage;

public class T4CreateByLambda {
    
    public static void main(String[] args) throws InterruptedException {
        logShortMessage("Starting Main Thread ..");

        Thread thread = new Thread(() -> task());//Invoking Runnable Lambda

        thread.join();
        logShortMessage("Ending Main Thread ..");

    }

    private static void task() {
        T5CreateByMethodReference.doSomething();
    }

}

