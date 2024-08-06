package nitin.multithreading;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.utilities.MultiThreadUtility.logShortMessage;
import static com.utilities.PerformanceUtility.startTimer;
import static com.utilities.PerformanceUtility.stopTimer;

public class ParallelFactorial {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = List.of(100L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L);

        List<Thread> threads = new ArrayList<>();
        Factorial factorial = new Factorial();

        for (int i = 0; i < inputNumbers.size(); i++){
            //factorial.add(inputNumbers.get(i));
        }

        for (long inputNumber : inputNumbers) {
            threads.add(new Thread(() -> {
                BigInteger computedFactorial = factorial.compute(inputNumber);
                logShortMessage(STR."Factorial of \{inputNumber} is \{computedFactorial}");
            }));
        }

        startTimer();
        for (Thread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join(2000);//Wait for NOT MORE THAN 2 seconds
        }
        stopTimer();
    }
}