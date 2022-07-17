package com.utilities;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Slf4j
public class PerformanceUtility {
    private static Log log = LogFactory.getLog(PerformanceUtility.class);

    public static StopWatch stopWatch = new StopWatch();

    public static void startTimer(){
        stopWatch.start();
    }

    public static void stopTimer(){
        stopWatch.stop();
        System.out.println("Total Execution Time in milliseconds: " +stopWatch.getTime() + " ms");
    }

    public static void resetTimer(){
        stopWatch.reset();
    }

    public static int noOfCores(){
        return Runtime.getRuntime().availableProcessors();
    }
}
