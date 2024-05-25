package sandbox;

/**
 * @author Created by nichaurasia
 * Created on Sunday, December/20/2020 at 8:38 AM
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class LogDemo {
    private static final Log logger = LogFactory.getLog(LogDemo.class);

    public static void main(String[] args) {
        logger.info("Test info");
        logger.debug("Test info");
        logger.error("Test error");
    }
}
