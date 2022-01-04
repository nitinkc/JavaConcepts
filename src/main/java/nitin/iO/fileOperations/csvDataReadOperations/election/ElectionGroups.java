package nitin.iO.fileOperations.csvDataReadOperations.election;

import nitin.iO.fileOperations.csvDataReadOperations.election.election.ElectionEntity;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Created by nichaurasia
 * Created on Wednesday, September/30/2020 at 11:22 PM
 */

public class ElectionGroups {
    private static final Comparator<Map.Entry<String, Integer>> valueOrder = Map.Entry.<String, Integer>comparingByValue().reversed();
    private static final Comparator<Map.Entry<String, Integer>> reversedValueOrder = valueOrder.reversed();

    public static void main(String[] args) {
        List<ElectionEntity> list = ReadElectionCsv.getData();
        System.out.println("Total number of records : " + list.size());

        System.out.println("**************************************************************");
        System.out.println("Get all votes by Party");

        sumVotesByParty(list);
    }

    private static void sumVotesByParty(List<ElectionEntity> list) {
        list.stream()
                .collect(Collectors.groupingBy(ElectionEntity::getParty,
                        Collectors.summingInt(ElectionEntity::getVotes)))
                .entrySet()
                .stream()
                .sorted(reversedValueOrder)
                .limit(20)
                .forEach(l -> System.out.printf("%40s : %5d\n", l.getKey(), l.getValue()));
    }
}
