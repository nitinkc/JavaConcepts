package com.utilities;

import com.entity.Cancer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class CsvReadUtility {

    public static List<Cancer> getCancerData() {
        String fileName = "src/main/resources/cancer.csv";
        Path path = Paths.get(fileName);
        List<Cancer> list = null;

        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list =
                    stream.map(str -> str.split(",", -1))
                            .skip(1)
                            .map(
                                    strArr -> {
                                        String[] temp = strArr;
                                        Cancer c;
                                        c =
                                                new Cancer(
                                                        org.apache.commons.lang3.StringUtils
                                                                .defaultString(temp[0], null),
                                                        org.apache.commons.lang3.StringUtils
                                                                .defaultString(temp[1], null),
                                                        NumberUtils.toInt(temp[2], -1),
                                                        org.apache.commons.lang3.StringUtils
                                                                .defaultString(temp[3], null),
                                                        StringUtils.defaultString(temp[4], null),
                                                        NumberUtils.toFloat(temp[5], -1),
                                                        NumberUtils.toInt(temp[6], -1),
                                                        NumberUtils.toFloat(temp[7], -1));
                                        return c;
                                    })
                            .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
