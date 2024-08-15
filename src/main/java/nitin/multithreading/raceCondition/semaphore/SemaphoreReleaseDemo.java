package nitin.multithreading.raceCondition.semaphore;

public class SemaphoreReleaseDemo {
    public static void main(String[] args) {
        SemaphoreTask task1 = new SemaphoreTask("Thread 1", true);//Ensuring only this thread acquired permit
        // Create threads that will execute the tasks
        Thread thread1 = new Thread(() -> task1.runTask());
        thread1.start();

        for (int i = 1; i <= 5; i++) {
            int threadNumber = i; // Capture loop variable for use in lambda
            Thread.ofPlatform()
                    .name("LoopThread-" + threadNumber)
                    .daemon(true)
                    .start(() -> new SemaphoreTask("Thread-" + threadNumber, false).runTask());
        }
    }
}
