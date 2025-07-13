package nitin.multithreading.cVirtualThreads.v3structuredConcurrency;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;
import java.util.concurrent.StructuredTaskScope.Subtask.State;

public class StructuredTaskScopeRunner {

    public static void main(String[] args) throws Exception {
        System.out.println("Main thread : Start : " + Thread.currentThread());

        // Simulate interrupt to the Main Thread before Child threads complete
        // interruptMain();
        // shutdownOnFailure();
        shutdownOnSuccess();
        // completeAllTasks();

        System.out.println("Main Thread : Complete: " + Thread.currentThread());
    }

    private static void completeAllTasks() throws InterruptedException {
        var tasks =
                List.of(
                        new BlockingIOTasks("task1", 3, false),
                        new BlockingIOTasks("task2", 5, false));

        try (var scope = new StructuredTaskScope<BlockingIOTasks.TaskResponse>()) {

            // Start running the tasks in parallel
            List<Subtask<BlockingIOTasks.TaskResponse>> subtasks =
                    tasks.stream().map(task -> scope.fork(task)).toList();

            // Code to simulate random exception being thrown
            // This should still terminate the child threads
            // if (true) {
            //	Thread.sleep(Duration.ofSeconds(2));
            //	throw new RuntimeException("Some Exception");
            // }

            // Wait for all tasks to complete (success or not)
            scope.join();

            subtasks.stream()
                    .forEach(
                            subTask -> {
                                // Handle Child Task Results (might have succeeded or failed)
                                State taskState = subTask.state();
                                if (taskState == State.SUCCESS) System.out.println(subTask.get());
                                else if (taskState == State.FAILED)
                                    System.out.println(subTask.exception());
                            });
        }
    }

    private static void shutdownOnFailure() throws InterruptedException, ExecutionException {

        var tasks =
                List.of(
                        new BlockingIOTasks("Task#1", 3, true),
                        new BlockingIOTasks("Task#2", 5, true),
                        new BlockingIOTasks("Task#3", 7, true));

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {

            // Start running the tasks in parallel
            List<Subtask<BlockingIOTasks.TaskResponse>> subtasks =
                    tasks.stream().map(task -> scope.fork(task)).toList();

            // Wait for all tasks to complete (success or not)
            scope.join();
            scope.throwIfFailed(); // Wait till first Child Task fails. Send cancellation to all
            // other Child Tasks

            // Handle Success Child Task Results
            subtasks.forEach(System.out::println);
        }
    }

    private static void shutdownOnSuccess() throws InterruptedException, ExecutionException {
        var tasks =
                List.of(
                        new BlockingIOTasks("Price-1", 3, true),
                        new BlockingIOTasks("Price-2", 10, true));

        try (var scope =
                new StructuredTaskScope.ShutdownOnSuccess<BlockingIOTasks.TaskResponse>()) {
            // Start running the tasks in parallel
            List<Subtask<BlockingIOTasks.TaskResponse>> list =
                    tasks.stream().map(task -> scope.fork(task)).toList();

            // Wait till first Child Task Succeeds. Send Cancellation
            // to all other Child Tasks
            scope.join();

            // Handle Successful Child Task
            BlockingIOTasks.TaskResponse result = scope.result();
            System.out.println(result);
        }
    }

    private static void interruptMain() {

        Thread mainThread = Thread.currentThread();
        Thread.ofPlatform()
                .start(
                        () -> {
                            try {
                                Thread.sleep(Duration.ofSeconds(2));
                                mainThread.interrupt();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
    }
}
