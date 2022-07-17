package com.utilities;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static java.lang.Thread.sleep;

@Slf4j
public class MultiThreadUtility {

    private static Log logger = LogFactory.getLog(MultiThreadUtility.class);

    public static void delay(long delayMilliSeconds)  {
        try{
            sleep(delayMilliSeconds);
        }catch (Exception e){
            log.info("Exception is :" + e.getMessage());
        }
    }

    public static void logMessage(String message){
        System.out.println(Thread.currentThread().getName() + " :: "  + message);
    }
}
