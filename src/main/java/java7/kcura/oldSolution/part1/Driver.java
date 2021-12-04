package java7.kcura.oldSolution.part1;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by Nitin Chaurasia on 11/9/15 at 3:43 PM as a part of the kCura interview process.
 *
 * The data is present in a file the name of which is expected as a command line argument.
 * If the file name is not given, the program terminates giving an error
 * NOTE: The Data is assumed to be in a predefined format, thus the check for the
 * correctness and formatting of data is avoided here.
 */


/*
    * Main Class that runs the project
    * Arguments to the main function is a name of the file containing data in pipe delimited format
    * delimited form
 */

public class Driver {
    public static final String CITIES_FILE = "Cities_By_Population.txt";
    public static final String INTERSTATES_FILE = "Interstates_By_City.txt";

    public static void main(String[] args){
        Driver driver = new Driver();
        driver.deleteOutputFiles();
        if (args.length == 0 || args.length > 1) {
            System.err.println("Usage: java DriverMain <fileNamer>");
            return;
        }
        // fileName contains the name of the file containing initial Data.
        String fileName = args[0];

        //Read the contents of the file and store locally
        File dataFile = new File(fileName);
        Scanner input = null;
        try {
            input = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        // To keep the data of the File into list of Objects of type Data
        List<Data> list = new ArrayList<Data>();

        /* Read from the File, assuming the file is properly sanitized
           The contents are put in the form of objects of type Data into a
           List.
         */
        while (input.hasNext()){
            //Split the tokens based on the delimiter "\"
            String[] temp = input.nextLine().split("\\|");

            //Put the tokens into an Object of Data Class and continue making a List of Data Object
            Data tempData = new Data();

            //Population in 100 thousands
            tempData.setPopulation(Integer.parseInt(temp[0]));
            tempData.setCity(temp[1]);
            tempData.setState(temp[2]);

            // Make a list of Interstates and Sort them for the convinience.
            String[] interstates = temp[3].split(";");
            //Sort the interstates and then put into the Object
            tempData.setInterstates(driver.sortInterstates(interstates));

            list.add(tempData);
        }

        // Method to solve Exercise of Option 1, part 1
        driver.writeCitiesByPopulation(list);

        // Method to solve Exercise of Option 1, part 2
        driver.writeInterstatesByCity(list);

        System.out.println("Program Terminates Successfully");
    }

    /* Utility method to delete the files.
     * in case of testing it is used */
    public void deleteOutputFiles() {
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


    /**
     * Solving First Part of Option 1 in which data is written in a file named Cities_By_Population.txt
     * In a specified format with a customized sorting order.
     */
    public void writeCitiesByPopulation(List<Data> list){

        FileWriter fw = null;
        try {
            //Overwrite in the File
            fw = new FileWriter(CITIES_FILE, false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        PrintWriter printToFile = new PrintWriter(fw);

        // Sort the List of Objects based on the Population
        Collections.sort(list, new PopulationComparator());

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

    /**
     * Solving Second Part of Option 1 in which the count of Interstates is to be written in a
     * file named Interstates_By_City.txt. The Interstates name will be in the Ascending order
     */
    private void writeInterstatesByCity(List<Data> list) {

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
        Map<String, Integer> interstateCount = new TreeMap<String, Integer>();

        while (itr.hasNext()) {
            Data curr = itr.next();
            List<String> temp = curr.getInterstates();

            for (int i = 0; i < temp.size(); i++) {
                String currInterstateName = temp.get(i);
                //If the Interstate is not there in the Hashmap
                if (!interstateCount.containsKey(currInterstateName)) {
                    interstateCount.put(currInterstateName, 1);
                } else {
                    //Increment the count by one
                    interstateCount.put(currInterstateName, interstateCount.get(currInterstateName) + 1);
                }
            }
        }

        List<String> AllInterstatesSorted = new ArrayList<String>();
        for (String key : interstateCount.keySet()){
            AllInterstatesSorted.add(key);
        }

        //Keep a sorted list of Interstates to get the matching values from the Map
        Collections.sort(AllInterstatesSorted,new InterstateComparator());


        // Writing Interstates names and its count into the file
        for (int i = 0; i < AllInterstatesSorted.size(); i++){
            String key = AllInterstatesSorted.get(i);
            int value = interstateCount.get(key);
            printToFile.println(key + " " + value );
        }

        printToFile.close();
        System.out.println("Successfully saved data to file: " + INTERSTATES_FILE);
    }

    //Method to Sort the Interstates
    private List<String> sortInterstates(String[] interstates) {
        List<String> temp = Arrays.asList(interstates);
        Collections.sort(temp, new InterstateComparator());

        return temp;
    }

}

