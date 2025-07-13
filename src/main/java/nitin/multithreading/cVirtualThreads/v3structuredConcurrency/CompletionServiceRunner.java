package nitin.multithreading.cVirtualThreads.v3structuredConcurrency;

import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceRunner {

    public static void main(String[] args) throws Exception {
        // Handle parallel tasks using CompletionService.
        List<BlockingIOTasks.TaskResponse> result = doParallelWork();
        System.out.println(STR."Parallel Work output = \{result}");
    }

    private static List<BlockingIOTasks.TaskResponse> doParallelWork() throws Exception {
        // Create the tasks
        var tasks =
                List.of(
                        new BlockingIOTasks("dbCall", 3, true),
                        new BlockingIOTasks("networkCall", 10, false));
        try (var service = Executors.newVirtualThreadPerTaskExecutor()) {
            CompletionService<BlockingIOTasks.TaskResponse> completionService =
                    new ExecutorCompletionService<BlockingIOTasks.TaskResponse>(service);

            List<Future<BlockingIOTasks.TaskResponse>> taskFutures =
                    tasks.stream().map(completionService::submit).toList();

            try {
                for (int j = 0; j < taskFutures.size(); j++) {
                    completionService.take().get();
                }
            } catch (Exception e) {
                // request that the threads terminate. Do not wait for the threads to terminate
                for (var taskFuture : taskFutures) {
                    taskFuture.cancel(true);
                }
                throw e;
            }

            // All tasks are successful at this point
            List<BlockingIOTasks.TaskResponse> result =
                    taskFutures.stream().map(Future::resultNow).toList();

            System.out.println(result);
            return result;
        } // makes sure that all threads are fully terminated
    }
}
