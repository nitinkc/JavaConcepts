package com.nitin.zOReiley2020SimonRoberts.f5streamsAPI;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author Created by nichaurasia
 * @create on Saturday, September/19/2020 at 12:36 AM
 */

public class FilesRead {
    private static final Pattern WORD_BREAK = Pattern.compile("\\W+");

    private static final Comparator<Map.Entry<String, Long>> valueOrder = Map.Entry.comparingByValue();

    private static final Comparator<Map.Entry<String, Long>> keyOrder = Map.Entry.comparingByKey();

    private static final Comparator<Map.Entry<String, Long>> reversedValue = valueOrder.reversed();

    public static void main(String[] args) throws Throwable {

        String file1 = "Java8/src/main/java/com/nitin/zRevisionsSep2020/f5streamsAPI/PrideAndPrejudice.txt";
        String file2 = "Java8/src/main/java/com/nitin/zRevisionsSep2020/f5streamsAPI/SenseAndSensibility.txt";

        Files.lines(Paths.get("PrideAndPrejudice.txt"))
                //.flatMap( l -> WORD_BREAK.splitAsStream(l))
                .flatMap(WORD_BREAK::splitAsStream)
                //.peek(System.out::println)
                .filter(l -> l.length() >0) //removing all the empty space
                //.map(w -> w.toLowerCase())
                .map(String::toLowerCase)//Making all the words in same case.
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted(reversedValue)
                .limit(100)
                .forEach(l -> System.out.printf("%20s : %5d\n", l.getKey(), l.getValue()));

    }
}
