package nitin.virtualThreads.v3structuredConcurrency;

import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import nitin.virtualThreads.v3structuredConcurrency.BlockingIOTasks.TaskResponse;

public class CompletionServiceRunner {
    
    public static void main(String[] args) throws Exception {
        //Handle parallel tasks using CompletionService.
        List<TaskResponse> result = doParallelWork();
        System.out.println(STR."Parallel Work output = \{result}");
    }

    private static List<TaskResponse> doParallelWork() throws Exception {
        // Create the tasks
        var tasks = List.of(
                new BlockingIOTasks("dbCall", 3,true),
                new BlockingIOTasks("networkCall", 10,false)
        );
        try (var service = Executors.newVirtualThreadPerTaskExecutor()) {
            CompletionService<TaskResponse> completionService = new ExecutorCompletionService<TaskResponse>(service);

            List<Future<TaskResponse>> taskFutures 
                = tasks.stream()
                    .map(completionService::submit)
                    .toList();

            try {
                for(int j = 0; j < taskFutures.size() ; j++) {
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
            List<TaskResponse> result 
            	= taskFutures.stream().map(Future::resultNow).toList();
            
            System.out.println(result);
            return result;
        } // makes sure that all threads are fully terminated
    }
}