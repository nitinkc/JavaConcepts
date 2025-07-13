package nitin.multithreading.raceCondition.eVolatileVar;

import static com.utilities.MultiThreadUtility.logShortMessage;

public class DataRace {
    // Data race can avoided by declaring the variables volatile
    private volatile int x = 0;
    private volatile int y = 0;

    public void increment() {
        x++;
        y++;
    }

    public void checkForDataRace() {
        if (y > x) {
            logShortMessage("y > x - Data Race is detected" + " x = " + x + ", y = " + y);
        }
    }
}
