package nitin.multithreading.bFuturesAndCompletableFutures.futures;

import java.util.concurrent.*;

/*
 * This class has methods whichs submits tasks in multiple ways.
 * You can uncomment the method call in main and run to play with these. 
 */
@SuppressWarnings("unused")
public class FuturesPlay {

    public static void main(String[] args) throws Exception {

        // Example of submitting a Runnable Task
        // exampleSubmitRunnable(); 
        
        // Example of submitting a Callable Task and getting TaskResult
        // exampleSubmitOneCallable();
        
        // Example of submitting multiple Callable Tasks
        // exampleSubmitMultipleCallables();
        
        // Example of submitting multiple Callable Tasks
        // using the ExecutorCompletionService
        exampleSubmitTasksUsingCompletionService();
        
        // Example using FutureTask
        // exampleFutureTasks();
    }

    private static void exampleFutureTasks() {

        OurFutureTask<TaskResult> task1 = new OurFutureTask<>(() -> FuturesPlay.doTask("task1", 1, true));
        OurFutureTask<TaskResult> task2 = new OurFutureTask<>(() -> FuturesPlay.doTask("task2", 4, false));

        try (ExecutorService service = Executors.newCachedThreadPool()) {

            Future<?> future1 = service.submit(task1);
            Future<?> future2 = service.submit(task2);

            // wait for both to complete
            future1.get();
            future2.get();

            // do other tasks

        } catch (Exception e) {
            // handle exceptions
        }

        System.out.println("Completed all");
    }


    // Becomes complex when dealing with chaining
    static void exampleSubmitTasksUsingCompletionService() {

            try (ExecutorService service = Executors.newFixedThreadPool(3)) {

                ExecutorCompletionService<TaskResult> srv 
                                        = new ExecutorCompletionService<>(service);

                Callable<TaskResult> callable1 = () -> FuturesPlay.doTask("task1", 2, false);
                Callable<TaskResult> callable2 = () -> FuturesPlay.doTask("task2", 1, false);

                Future<TaskResult> task1Future = srv.submit(callable1);
                Future<TaskResult> task2Future = srv.submit(callable2);

                try {
                    for (int j = 0; j < 2; j++) {

                        Future<TaskResult> future = srv.take();
                        if (future == task1Future) {
                            // handle task1 future
                            System.out.println(future.get());
                        }
                        else if (future == task2Future) {
                            // handle task2 future
                            System.out.println(future.get());
                        }
                    }
                }
                catch (InterruptedException | ExecutionException e) {
                    System.out.println(e);
                }

        }
    }


    static void exampleSubmitMultipleCallables() {

        try (ExecutorService service = Executors.newFixedThreadPool(3)) {

            Future<TaskResult> task1Future = service.submit(() -> FuturesPlay.doTask("task1", 3, false));
            Future<TaskResult> task2Future = service.submit(() -> FuturesPlay.doTask("task2", 2, false));
            Future<TaskResult> task3Future = service.submit(() -> FuturesPlay.doTask("task3", 1, false));

            try {

                // Handle taskData1. get() will block till task1 completes
                TaskResult taskResult1 = task1Future.get();
                System.out.println(taskResult1);

                // Handle taskData2. get() will block till task2 completes
                TaskResult taskResult2 = task2Future.get();
                System.out.println(taskResult2);

                // Handle taskData3. get() will block till task3 completes
                TaskResult taskResult3 = task3Future.get();
                System.out.println(taskResult3);

            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            }
        }

    }

    static void exampleSubmitOneCallable() {

        try (ExecutorService service
                     = Executors.newFixedThreadPool(3)) {

            Future<TaskResult> future
                = service.submit(
                    () -> FuturesPlay.doTask("SimpleTask", 1, false));

            // supposed to do some other work

            try {
                TaskResult taskData = future.get();
                System.out.println(taskData);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            }
        }

    }

    static void exampleSubmitRunnable()
                        throws ExecutionException, InterruptedException {

        // Submit a Task
        try(ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<?> future = service.submit(FuturesPlay::doSimpleTask);

            // do other tasks here

            // wait for future to complete
            future.get();

            // do something else

        }
    }

    public static void doSimpleTask() {

        System.out.printf("%s : Starting Simple Task\n",
                Thread.currentThread().getName());
        try {

            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {
            System.out.println("Task Interrupted");
        }

        System.out.printf("%s : Ending Simple Task\n",
                Thread.currentThread().getName());
    }

    public static TaskResult doTask(String name, int secs, boolean fail) {

        System.out.printf("%s : Starting Task %s\n",
                Thread.currentThread().getName(), name);

        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        if (fail) {
            throw new RuntimeException("Task Failed : " + name);
        }

        System.out.printf("%s : Ending Task %s\n",
                Thread.currentThread().getName(), name);
        return new TaskResult(name, secs);
    }

}
