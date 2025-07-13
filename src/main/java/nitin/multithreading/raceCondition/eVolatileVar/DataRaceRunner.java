package nitin.multithreading.raceCondition.eVolatileVar;

public class DataRaceRunner {
    public static void main(String[] args) {
        DataRace sharedClass = new DataRace();
        Thread thread1 =
                new Thread(
                        () -> {
                            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                                sharedClass.increment();
                            }
                        });

        Thread checkerThread =
                new Thread(
                        () -> {
                            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                                sharedClass.checkForDataRace();
                            }
                        });

        thread1.start();
        checkerThread.start();
    }
}
