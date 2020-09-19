package com.nitin.zRevisionsSep2020.f5streamsAPI;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * @Author Created by nichaurasia
 * @create on Saturday, September/19/2020 at 12:36 AM
 */

public class FilesRead {
    private static final Pattern WORD_BREAK = Pattern.compile("\\W+");

    public static void main(String[] args) throws Throwable {
        Files.lines(Paths.get("PrideAndPrejudice.txt"))
                .flatMap( l -> WORD_BREAK.splitAsStream(l))
                .filter(l -> l.length() >0)
                .forEach(l -> System.out.println(l));

    }
}
