package nitin.multithreading.aBasics.aPlatformThreads;

import static com.utilities.MultiThreadUtility.logShortMessage;

public class T4CreateByLambda {
    
    public static void main(String[] args) throws InterruptedException {
        logShortMessage("Starting Main Thread ..");

        Thread thread = new Thread(() -> task(12,24));//Invoking Runnable Lambda
        thread.join();
        logShortMessage("Ending Main Thread ..");

    }

    private static void task(int a, int b) {
        T5CreateByMethodReference.doSomething();
    }

}

