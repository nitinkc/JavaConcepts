package nitin.virtualThreads.v6DelimitedContinuations;

import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

import java.time.ZonedDateTime;

import static com.utilities.MultiThreadUtility.logShortMessage;
import static com.utilities.ZonedDateTimeUtility.zonedDateTimeStr;

public class RunnableContinuationProcessor implements Runnable {

    private static final ContinuationScope SCOPE = new ContinuationScope("newScope");

    @Override
    public void run() {
        method();
    }

    private void method() {
        logShortMessage("RunnableContinuationProcessor.run : enter");

        Continuation c = new Continuation(SCOPE, this::continuationMethod);
        while (!c.isDone()) {
            c.run();
            logShortMessage("##### scope2 continuation #####");
        }
        logShortMessage("RunnableContinuationProcessor.run : exit");
    }


    private void continuationMethod() {
        logShortMessage("RunnableContinuationProcessor.continuationMethod : enter");
        Incrementer incrementer = new Incrementer(1, zonedDateTimeStr(ZonedDateTime.now()));

        logShortMessage("State 1 : " + incrementer);
        //Restores the state
        Continuation.yield(SCOPE);//Run until here and send the control back to the main method

        //Restore from previous point, Resumes the state
        modifyIncrementer(incrementer);
        logShortMessage("State 2 : " + incrementer);
        Continuation.yield(SCOPE);

        //Restore from previous point, Resumes the state
        modifyIncrementer(incrementer);
        logShortMessage("State 3 : " + incrementer);
        Continuation.yield(SCOPE);

        logShortMessage("RunnableContinuationProcessor.continuationMethod : exit");
    }

    private static void modifyIncrementer(Incrementer incrementer) {
        incrementer.setCounter(incrementer.getCounter() + 1);
        incrementer.setTimeOfIncrement(zonedDateTimeStr(ZonedDateTime.now()));
    }
}
