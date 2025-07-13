package nitin.multithreading;

public class ThreadLifeCycleAdvanced {
    public static void main(String[] args) {
        Thread yieldThread = new Thread(new YieldTask(), "YieldThread");
        Thread blockThread = new Thread(new BlockTask(), "BlockThread");
        Thread timedWaitThread = new Thread(new TimedWaitTask(), "TimedWaitThread");

        log("Main thread: Starting YieldThread");
        yieldThread.start();
        log("Main thread: YieldThread started, state: " + yieldThread.getState());

        log("Main thread: Starting BlockThread");
        blockThread.start();
        log("Main thread: BlockThread started, state: " + blockThread.getState());

        log("Main thread: Starting TimedWaitThread");
        timedWaitThread.start();
        log("Main thread: TimedWaitThread started, state: " + timedWaitThread.getState());

        try {
            yieldThread.join();
            blockThread.join();
            timedWaitThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log("Main thread: All threads have completed execution");
    }

    static class YieldTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                log(Thread.currentThread().getName() + " - Running iteration " + i);
                if (i % 2 == 0) {
                    log(Thread.currentThread().getName() + " - Yielding");
                    Thread.yield();
                    log(
                            Thread.currentThread().getName()
                                    + " - After yield, state: "
                                    + Thread.currentThread().getState());
                }
            }
        }
    }

    static class BlockTask implements Runnable {
        private static final Object lock = new Object();

        @Override
        public void run() {
            log(Thread.currentThread().getName() + " - Attempting to acquire lock");
            synchronized (lock) {
                log(Thread.currentThread().getName() + " - Acquired lock");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log(Thread.currentThread().getName() + " - Releasing lock");
            }
            log(Thread.currentThread().getName() + " - Lock released");
        }
    }

    static class TimedWaitTask implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                try {
                    log(Thread.currentThread().getName() + " - Entering timed waiting state");
                    wait(3000);
                    log(Thread.currentThread().getName() + " - Exiting timed waiting state");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void log(String message) {
        System.out.println(message);
    }
}
