package com.nitin.kcura.java8Solution;

import java.io.*;
import java.nio.file.Files;
import java.util.*;


/**
 * Created by nitin on Sunday, October/06/2019 at 10:50 PM
 */
public class Driver8 {

    public static final String CITIES_FILE = "Cities_By_Population.txt";
    public static final String CITIES_FILE_REVERSED = "Cities_By_Population.txt";
    public static final String INTERSTATES_FILE = "Interstates_By_City.txt";

    public static void main(String[] args) {
        if (args.length == 0 || args.length > 1) {

            System.err.println("Supply a commandline argument \n" +
                    "Usage: java DriverMain <fileName>");
            return;
        }

        deleteOutputFiles();
        File dataFile = new File(args[0]);
        // To keep the data of the File into list of Objects of type Data
        List<Data> list = new ArrayList<>();

        readDataFromFile(list, dataFile);
        writeCitiesByPopulation(list);
        // Method to solve Exercise of Option 1, part 2
        writeInterstatesByCity(list);

        System.out.println("Program Terminates Successfully");
    }

    private static void writeInterstatesByCity(List<Data> list) {

        FileWriter fw = null;
        try {
            //Overwrite the File
            fw = new FileWriter(INTERSTATES_FILE, false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        PrintWriter printToFile = new PrintWriter(fw);

        Iterator<Data> itr = list.listIterator();

        //Map to hold the names of the Interstates and its count
        Map<String, Integer> interstateCountMap = new TreeMap<String, Integer>();

        while (itr.hasNext()) {
            Data curr = itr.next();
            List<String> temp = curr.getInterstates();

            for (int i = 0; i < temp.size(); i++) {
                String currInterstateName = temp.get(i);
                //If the Interstate is not there in the Hashmap
                if (!interstateCountMap.containsKey(currInterstateName)) {
                    interstateCountMap.put(currInterstateName, 1);
                } else {
                    //Increment the count by one
                    interstateCountMap.put(currInterstateName, interstateCountMap.get(currInterstateName) + 1);
                }
            }
        }

        Iterator<String> itr2 = interstateCountMap.keySet().iterator();

        while(itr2.hasNext()){
            String key = itr2.next();
            int value = interstateCountMap.get(key);
            printToFile.println(key + " " + value);
        }

        printToFile.close();
        System.out.println("Successfully saved data to file: " + INTERSTATES_FILE);
    }

    private static void writeCitiesByPopulation(List<Data> list) {

        // Sort the List of Objects based on the Population
        list.sort(Comparator
                .comparing(Data::getPopulation).reversed()
                .thenComparing(Data::getState)
                .thenComparing(Data::getCity));

        list.forEach(System.out::println);
        FileWriter fw = null;
        try {
            //Overwrite in the File
            fw = new FileWriter(CITIES_FILE, false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        PrintWriter printToFile = new PrintWriter(fw);

        // Write the formatted Data into file
        Iterator<Data> itr = list.listIterator();
        int currentPopulation = -1;
        while (itr.hasNext()){
            Data curr = itr.next();
            // Grouping the cities with same population, if the population is same, all cities are clubbed
            if (currentPopulation == curr.getPopulation()) {
                printToFile.println(curr.aggragateCities());
            } else {
                currentPopulation = curr.getPopulation();
                printToFile.println(curr.toString());
            }
        }

        printToFile.close();//Should have flushed also
        System.out.println("Successfully saved data to file: " + CITIES_FILE);
    }

    private static void readDataFromFile(List<Data> list, File dataFile) {
        //Argument has file name.Read the contents of the file and store locally
        Scanner input = null;
        try {
            input = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        while (input.hasNext()) {
            //Split the tokens based on the delimiter "\"
            String temp[] = input.nextLine().split("\\|");

            //Put the tokens into an Object of Data Class and continue making a List of Data Object
            Data tempData = new Data();

            //Population in 100 thousands
            tempData.setPopulation(Integer.parseInt(temp[0]));
            tempData.setCity(temp[1]);
            tempData.setState(temp[2]);

            //Sort the interstates and then put into the Object
            List<String> interstateList = Arrays.asList(temp[3].split(";"));
            //Sorting the List with interstate number
            interstateList.sort(Comparator.naturalOrder());
            tempData.setInterstates(interstateList);

            list.add(tempData);
        }
    }

    /* Utility method to delete the files.
     * in case of testing it is used */
    private static void deleteOutputFiles() {
        File citiesFile = new File(CITIES_FILE);
        File interstatesFile = new File(INTERSTATES_FILE);
        try {
            Files.deleteIfExists(citiesFile.toPath());
            Files.deleteIfExists(interstatesFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Unable to delete output files.");
        }
    }
}
