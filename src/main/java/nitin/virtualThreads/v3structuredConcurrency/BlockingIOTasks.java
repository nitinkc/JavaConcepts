package nitin.virtualThreads.v3structuredConcurrency;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.util.concurrent.Callable;

import nitin.exceptionHandling.customizedExceptions.BusinessException;
import nitin.virtualThreads.v3structuredConcurrency.BlockingIOTasks.TaskResponse;

@AllArgsConstructor
public class BlockingIOTasks implements Callable<TaskResponse> {
    private final String jobName;
    private final int time;
    private final boolean isSuccessful;
    
    // Represents successful response of the Task
    public record TaskResponse(String name, String response, long timeTaken) { }

    // Executes when the executorService.submit(task) is run;
    @Override
    public TaskResponse call() throws InterruptedException, BusinessException {
        return getTaskResponse();
    }

    //Body of the task which will be run on a separate Thread (mostly  Virtual Thread)
    // It responds to interrupts and cleanly terminates on interruption or failure.
    private TaskResponse getTaskResponse() throws InterruptedException, BusinessException {
        logMessage("Start");
        long start = System.currentTimeMillis();

        //Simulating long running task.
        for (int i = 1; i <= time; i++) {
            if (Thread.interrupted()) {//Checking the interrupt
                throwInterruptedException();
            }
            logMessage("Working since.." + i + " seconds");
            Thread.sleep(Duration.ofSeconds(1));//Time taken for some blocking io operation
        }

        /* simulate failure of task */
        if (!isSuccessful) {
            throwExceptionOnFailure();
        }

        logMessage("Complete");
        long end = System.currentTimeMillis();

        //Simulating CPU intensive operation
        String fakeResponse = Faker.instance().harryPotter().character();
        return new TaskResponse(this.jobName, fakeResponse, end - start);
    }

    private void throwExceptionOnFailure() throws BusinessException {
        logMessage("Failed");
        throw new BusinessException(STR."\{jobName} : Failed");
    }

    private void throwInterruptedException() throws InterruptedException {
        logMessage("Interrupted");
        throw new InterruptedException(STR."\{jobName} : Interrupted");
    }

    private void logMessage(String message) {
        System.out.printf("%s : %s : %s\n", jobName, message, Thread.currentThread());
    }
}