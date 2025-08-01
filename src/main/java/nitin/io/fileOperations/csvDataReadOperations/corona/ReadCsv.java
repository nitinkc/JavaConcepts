package nitin.io.fileOperations.csvDataReadOperations.corona;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author Created by nichaurasia Created on Tuesday, September/29/2020 at 11:23 PM
 */
public class ReadCsv {
    public static List<Entity> getData() {
        String file =
                "JavaLatest/src/main/java/com/fileOperations/csvDataReadOperations/corona/us_simplified.csv";

        return readFileNreturnList(file);
    }

    private static List<Entity> readFileNreturnList(String file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Entity> entityList =
                reader.lines()
                        .skip(1)
                        // .limit(200)
                        .map(line -> line.split(","))
                        .map(ReadCsv::makeObjects)
                        .collect(Collectors.toList());

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entityList;
    }

    private static Entity makeObjects(String[] line) {
        Entity e = null;
        try {
            e =
                    new Entity(
                            new SimpleDateFormat("yyyy-MM-dd").parse(line[0]),
                            NumberUtils.toInt(line[1], 0),
                            line[2],
                            line[3],
                            Integer.parseInt(line[4]),
                            Integer.parseInt(line[5]),
                            Integer.parseInt(line[6]),
                            line[7]);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        // System.out.println(e);
        return e;
    }
}
