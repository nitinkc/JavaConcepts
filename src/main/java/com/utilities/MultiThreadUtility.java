package com.utilities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static java.lang.Thread.sleep;

public class MultiThreadUtility {

    private static Log logger = LogFactory.getLog(MultiThreadUtility.class);

    public static void delay(long delayMilliSeconds)  {
        try{
            sleep(delayMilliSeconds);
        }catch (Exception e){
            logger.info("Exception is :" + e.getMessage());
        }
    }

    public static void logShortMessage(String message){
        System.out.println( message + ": " + Thread.currentThread().getName());
    }

    public static void logMessage(String message){
        System.out.println(message + " : "  + Thread.currentThread()  );
    }

    public static void foreverThread() {
        long numberOfHours = 1;
        Thread appThread = new Thread(()-> delay(numberOfHours * 60 * 1000));
        appThread.start();
    }
}
