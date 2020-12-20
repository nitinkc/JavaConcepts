package com.nitin.corona;

import org.apache.commons.lang3.time.StopWatch;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @Author Created by nichaurasia
 * @create on Wednesday, September/30/2020 at 11:22 AM
 */

public class CoronaServices {
    private final static Logger LOGGER = Logger.getLogger(CoronaServices.class.getName());

    public static void main(String[] args) {
        List<Entity> list = ReadCsv.getData();
        System.out.println("Total number of records : " + list.size());

        final StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        int totalDeaths = list.stream()
                //.parallel()
                .filter(entity -> entity.getDeaths() > 0)
                .mapToInt(entity -> entity.getDeaths())
                .sum();
        LOGGER.info("Starting long calculations: " + stopwatch);

        LOGGER.log(Level.WARNING, "Total Deaths : " + totalDeaths);
    }
}