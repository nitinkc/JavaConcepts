package nitin.multithreading;

public class ThreadLifecycle {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableTask());
        System.out.println("State: " + thread.getState()); // NEW

        thread.start();
        System.out.println("State: " + thread.getState()); // RUNNABLE

        try {
            // If main thread doesn't wait long enough, to allow runnable tasks to finish, the main thread will wait
            Thread.sleep(10); // Main thread sleeps to allow RunnableTask to execute\
            //Thread.sleep(1000); //Main thread sleeps to allow RunnableTask to execute, TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State: " + thread.getState()); // TIMED_WAITING or TERMINATED, depending on timing
    }
}

class RunnableTask implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                wait(50); // TIMED_WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("State: " + Thread.currentThread().getState()); // NEW
    }
}

