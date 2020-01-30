package com.nitin.a17Streams.fileStreams;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nichaurasia on Tuesday, January/28/2020 at 3:55 PM
 */

public class FileStream {
    public static void main(String args[]) throws URISyntaxException, IOException {
        String fileName = "src/main/resources/temp.csv";
        Path path = Paths.get(fileName);
        List<Cancer> list = null;

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .map(str -> str.split(","))
                    .skip(1)

                    .map(strArr -> {
                        String temp[] = strArr;
                        Cancer c;
                        if(null != temp[0] && null != temp[1] && null != temp[2] &&
                        null != temp[3] && null != temp[4] && null != temp[5] && null != temp[6]){
                            c = new Cancer(
                                    StringUtils.defaultString(temp[0],null),
                                    StringUtils.defaultString(temp[1],null),
                                    NumberUtils.toInt(temp[2], -1),
                                    StringUtils.defaultString(temp[3],null),
                                    StringUtils.defaultString(temp[4],null),
                                    NumberUtils.toFloat(temp[5],-1),
                                    NumberUtils.toInt(temp[6],-1),
                                    NumberUtils.toFloat(temp[7],-1)
                            );
                        }else{
                            c = new Cancer();
                        }
                        return c; })
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //list.stream().forEach(System.out::println);
    }
}
