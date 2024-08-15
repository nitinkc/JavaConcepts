package nitin.multithreading.raceCondition.shared;

public class SharedCounter {
    private int counter = 0;

    public void increment() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
    }

    public int getCounter() {
        return counter;
    }
}
