package com.utilities;

import org.apache.commons.lang3.time.StopWatch;

public class PerformanceUtility {

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
