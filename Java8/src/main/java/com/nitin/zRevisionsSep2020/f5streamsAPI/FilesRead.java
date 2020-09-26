package com.nitin.zRevisionsSep2020.f5streamsAPI;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
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

    private static final Comparator<Map.Entry<String, Long>> reversedValue = valueOrder.reversed();

    public static void main(String[] args) throws Throwable {
        Files.lines(Paths.get("Java8/src/main/java/com/nitin/zRevisionsSep2020/f5streamsAPI/PrideAndPrejudice.txt"))
                //.flatMap( l -> WORD_BREAK.splitAsStream(l))

                .flatMap(WORD_BREAK::splitAsStream)
                .filter(l -> l.length() >0)
                //.map(w -> w.toLowerCase())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted(reversedValue)
                .limit(100)
                .forEach(l -> System.out.printf("%20s : %5d\n", l.getKey(), l.getValue()));

    }
}
