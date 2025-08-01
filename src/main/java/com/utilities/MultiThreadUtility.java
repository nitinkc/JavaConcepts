package com.utilities;

import static java.lang.Thread.sleep;

import java.time.Duration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MultiThreadUtility {

    private static final Log logger = LogFactory.getLog(MultiThreadUtility.class);

    public static void delay(long delayMilliSeconds) {
        try {
            sleep(delayMilliSeconds);
        } catch (Exception e) {
            logger.info("Exception is :" + e.getMessage());
        }
    }

    public static void delaySeconds(long seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (Exception e) {
            logger.info("Exception is :" + e.getMessage());
        }
    }

    public static void logShortMessage(String message) {
        System.out.printf("[%s] %s\n", Thread.currentThread().getName(), message);
    }

    public static void logMessage(String message) {
        System.out.printf("%s %s\n", Thread.currentThread(), message);
    }

    public static void foreverThread() {
        long numberOfHours = 1;
        Thread appThread = new Thread(() -> delay(numberOfHours * 60 * 1000));
        appThread.start();
    }
}
