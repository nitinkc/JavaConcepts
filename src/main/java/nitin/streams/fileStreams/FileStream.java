package nitin.streams.fileStreams;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nichaurasia on Tuesday, January/28/2020 at 3:55 PM
 */

public class FileStream {
    public static void main(String[] args) throws URISyntaxException, IOException {
        String fileName = "src/main/resources/cancer.csv";
        Path path = Paths.get(fileName);
        List<Cancer> list = null;

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .map(str -> str.split(",", -1))
                    .skip(1)

                    .map(strArr -> {
                        String[] temp = strArr;
                        Cancer c;
                        c = new Cancer(
                                StringUtils.defaultString(temp[0], null),
                                StringUtils.defaultString(temp[1], null),
                                NumberUtils.toInt(temp[2], -1),
                                StringUtils.defaultString(temp[3], null),
                                StringUtils.defaultString(temp[4], null),
                                NumberUtils.toFloat(temp[5], -1),
                                NumberUtils.toInt(temp[6], -1),
                                NumberUtils.toFloat(temp[7], -1)
                        );
                        return c;
                    })
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<Integer, List<Cancer>> map = list.stream()
                .collect(Collectors.groupingBy(Cancer::getYear));

        for (Map.Entry<Integer, List<Cancer>> itr : map.entrySet()) {
            System.out.println("Key: " + itr.getKey() + "== Value: " + itr.getValue().stream().count());
        }

        Map<String, List<Cancer>> map2 = list.stream()
                .collect(Collectors.groupingBy(Cancer::getState));

        for (Map.Entry<String, List<Cancer>> itr : map2.entrySet()) {
            System.out.println("Key: " + itr.getKey() + "== Value: " + itr.getValue().stream().count());
        }
    }
}
