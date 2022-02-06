package nitin.io.fileOperations.csvDataReadOperations.election;

import nitin.io.fileOperations.csvDataReadOperations.election.election.ElectionEntity;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Created by nichaurasia
 * Created on Tuesday, September/29/2020 at 11:23 PM
 */

public class ReadElectionCsv {
    public static List<ElectionEntity> getData() {
        String file = "JavaLatest/src/main/java/com/fileOperations/csvDataReadOperations/election/india_general_election_2014.csv";

        return readFileNreturnList(file);
    }

    private static List<ElectionEntity> readFileNreturnList(String file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<ElectionEntity> entityList = reader.lines().skip(1)
                //.limit(200)
                .map(line -> line.split(","))
                .map(ReadElectionCsv::makeObjects)
                .collect(Collectors.toList());

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entityList;
    }


    private static ElectionEntity makeObjects(String[] line) {
        ElectionEntity e = null;
        //State,Assembly,Candidate,Party,Votes
        e = new ElectionEntity(line[0],
                line[1],
                line[2],
                line[3],
                NumberUtils.toInt(line[4], 0)
        );

        //System.out.println(e);
        return e;
    }
}