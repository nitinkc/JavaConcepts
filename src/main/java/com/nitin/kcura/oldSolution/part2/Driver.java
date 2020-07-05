package com.nitin.kcura.oldSolution.part2;

import com.nitin.kcura.oldSolution.part2.BredthFirstTraversal;
import com.nitin.kcura.oldSolution.part2.CitiesConnection;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Driver {
    public static final String CITIES_FILE = "Cities_By_Population.txt";
    public static final String INTERSTATES_FILE = "Interstates_By_City.txt";
    public static final String CITIES_FILE_REVERSED = "Cities_By_Population.txt";
    //public static final String FILE_PATH = "src\\main\\java\\com\\nitin\\kcura\\java8Solution\\";
    public static final String FILE_PATH = "src/main/java/com/nitin/kcura/oldSolution/part2/";

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
        File dataFile = new File(FILE_PATH+fileName);

        //Read the File
        Scanner input = null;
        try {
            input = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        // To keep the data of the File into list of Objects
        List<Data> list = new ArrayList<Data>();

        //Read from the File, assuming the file is properly sanitized
        while (input.hasNext()){
            //Split the tokens based on the delimiter "\"
            String[] temp = input.nextLine().split("\\|");

            //Put the tokens into an Object of Data Class and continue making a List of Data Object
            Data tempData = new Data();

            //Population in 100 thousands
            tempData.setPopulation(Integer.parseInt(temp[0]));

            tempData.setCity(new City(temp[1], temp[2]));

            // Make a list of Interstates and Sort them for the convinience.
            String[] interstates = temp[3].split(";");
            //Sort the interstates and then put into the Object
            Set<String> istates = new HashSet<String>();
            for (String str : interstates) {
                istates.add(str);
            }
            tempData.setInterstates(istates);

            list.add(tempData);
        }

        //Option2
        driver.printCitiesWithDistanceFromChicago(list);

        System.out.println("Program Terminates Successfully");
    }

    private void printCitiesWithDistanceFromChicago(List<Data> list) {
        CitiesConnection citiesConnection = new CitiesConnection();
        Data chicagoData = null;
        for (Data data : list) {
            citiesConnection.addNewCity(data);
               if (data.getCity().equals(new City("Chicago", "Illinois"))) {
                chicagoData = data;
            }
        }
        //citiesConnection.printAdjList();
        BredthFirstTraversal traversal = new BredthFirstTraversal();
        traversal.traverseGraph(citiesConnection.getAdjList(), chicagoData);
        traversal.printList();
    }

    /* Utility method to delete the files.
    * in case of testing it is used
    * */
    public void deleteOutputFiles() {
        File citiesFile = new File(FILE_PATH+CITIES_FILE);
        File interstatesFile = new File(FILE_PATH+INTERSTATES_FILE);
        try {
            Files.deleteIfExists(citiesFile.toPath());
            Files.deleteIfExists(interstatesFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Unable to delete output files.");
        }
    }

    //Method to Sort the Interstates
    private List<String> sortInterstates(String[] interstates) {
        List<String> temp = Arrays.asList(interstates);
        Collections.sort(temp, new InterstateComparator());

        return temp;
    }
}

