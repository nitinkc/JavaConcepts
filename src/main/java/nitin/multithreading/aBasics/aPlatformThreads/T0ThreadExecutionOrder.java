package nitin.multithreading.aBasics.aPlatformThreads;

public class T0ThreadExecutionOrder {
    public static void main(String[] args) {
        //By default, the platform threads are NON-DAEMON Threads, unless its explicitly marked daemon.
        Thread thread1 = new Thread(() -> System.out.println("1: I'm going for a walk"));
        Thread thread2 = new Thread(() -> System.out.println("2: I'm going to swim"));

        thread1.start();
        thread2.start();

        System.out.println("3: I'm going home");
    }
}
