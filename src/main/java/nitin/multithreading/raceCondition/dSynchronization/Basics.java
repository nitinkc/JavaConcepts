package nitin.multithreading.raceCondition.dSynchronization;

public class Basics {
    public synchronized void m1() {
        System.out.println("From M1... Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate time-consuming operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void m2() {
        System.out.println("From M2... Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate time-consuming operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void m3() {
        System.out.println("From M3... Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Simulate time-consuming operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
