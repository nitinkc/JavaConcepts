package com.nitin.election;

import org.apache.commons.lang3.time.StopWatch;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author Created by nichaurasia
 * @create on Wednesday, September/30/2020 at 5:41 PM
 */

public class ElectionService {
    private final static Logger LOGGER = Logger.getLogger(ElectionService.class.getName());

    public static void main(String[] args) {
        List<ElectionEntity> list = ReadElectionCsv.getData();
        System.out.println("Total number of records : " + list.size());

        final StopWatch stopwatch = new StopWatch();

        stopwatch.start();
        System.out.println("***********************************************************");
        System.out.println("Votes Casted in Indore");
        //votesInIndore(list);
        LOGGER.log(Level.INFO,"Starting long calculations: " + stopwatch);
        LOGGER.log(Level.OFF,"Starting long calculations: " + stopwatch);

        System.out.println("***********************************************************");
        System.out.println("Total Votes received by AAP in MP");
        int countAAPinMP = countAAPinMP(list,"Madhya Pradesh", "Aam Aadmi Party");
        System.out.println(countAAPinMP);


        System.out.println("***********************************************************");
        System.out.println("Total Votes received by Modi");
        list.stream()
                .filter(x -> x.getCandidate().contains("NARENDRA MODI"))
                .forEach(System.out::println);

        System.out.println("***********************************************************");
        System.out.println("Total Votes by each party in MP");
        //list.stream()
                //.flatMap()
    }

    private static Integer countAAPinMP(List<ElectionEntity> list, String state, String party) {
        return list.stream()
                .filter(x -> x.getState().equalsIgnoreCase(state))
                .filter(y -> y.getParty().equalsIgnoreCase(party))
                .map(z -> z.getVotes())
                .reduce(0, Integer::sum);
    }

    private static void votesInIndore(List<ElectionEntity> list) {
        list.stream()
        .filter(election -> election.getAssembly().equalsIgnoreCase("Indore"))
        .forEach(System.out::println);
    }
}
