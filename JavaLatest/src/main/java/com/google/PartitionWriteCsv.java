package com.google;

import com.google.common.collect.Lists;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PartitionWriteCsv {
    public static void main(String[] args) {
        final int BATCH_SIZE = 1000;

        //Read from a CSV file and Write into another
        String inputFile = "Java8/src/main/java/com/nitin/zCoreServletsTraining/t4FileIO/fileIO/readfiles1/enable1-word-list.txt";
        List<String> stringList = new ArrayList<>();
        try {
           stringList  = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<List<String>> partition= Lists.partition(stringList, BATCH_SIZE);

        long startP = System.currentTimeMillis();
        partition.forEach(singleStringList -> {
            singleStringList.parallelStream()
                    .forEach(singleString -> FileWrite.doSomethingParallely(singleString));
        });
        long endP = System.currentTimeMillis();

        long startS = System.currentTimeMillis();
        stringList.forEach(str -> FileWrite.doSomethingParallely(str));
        long endS = System.currentTimeMillis();

        results(stringList.size(), partition.size(), BATCH_SIZE, endP - startP, endS - startS);
        System.out.println("Processing Ended");
    }

    private static void results(int size, int partitionSize, int BATCH_SIZE, long parallelTime, long sequentialTime) {
        final String FILENAME = "JavaLatest/src/main/java/com/google/nitin.txt";
        PrintWriter output = null;
        // Erasing files if already exist
        try {
            output = new PrintWriter(new FileWriter(FILENAME, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        output.println("###########################################################################");
        output.println(LocalDateTime.now());
        output.println("Total # of Strings " + size + " with total # Partition is " + partitionSize);
        output.println("Batch Size : " + BATCH_SIZE);
        output.println("Total Time Taken in parallel : " + parallelTime);
        output.println("Total Time Taken in sequential : " + sequentialTime);

        // Does not write without flush
        output.flush();
        output.close();
    }
}
