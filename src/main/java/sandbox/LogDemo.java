package sandbox;

/**
 * @Author Created by nichaurasia
 * @create on Sunday, December/20/2020 at 8:38 AM
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class LogDemo
{
    private static Log logger = LogFactory.getLog(LogDemo.class);

    public static void main(String[] args)
    {
        logger.info("Test info");
        logger.debug("Test info");
        logger.error("Test error");

    }
}
