package com.nitin.kcura.oldSolution.part2;

import com.nitin.kcura.oldSolution.part2.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Nitin Chaurasia on 11/10/15 at 9:53 PM.
 */
public class CitiesConnection {

    private final Map<Data, Set<Data>> adjList = new HashMap<Data, Set<Data>>();

    public Map<Data, Set<Data>> getAdjList() {
        return adjList;
    }

    public boolean addNewCity(Data city) {
        if (adjList.containsKey(city)) {
            return false;
        }

        Set<Data> myAdjCities = new HashSet<Data>();
        for (Data currentCity : adjList.keySet()) {
            if (containsCommonInterstates(currentCity.getInterstates(), city.getInterstates())) {
                adjList.get(currentCity).add(city);
                myAdjCities.add(currentCity);
            }
        }
        adjList.put(city, myAdjCities);
        return true;
    }

    private boolean containsCommonInterstates(Set<String> interstates1, Set<String> interstates2) {
        for (String iState : interstates1) {
            if (interstates2.contains(iState)) {
                return true;
            }
        }
        return false;
    }

    //Utility function
    public void printAdjList() {
        for (Map.Entry<Data, Set<Data>> entry : adjList.entrySet()) {
            //System.out.println("Key: " + entry.getKey().getCity().getCityname() + ", " + entry.getKey().getCity().getState());
            for (Data connection : entry.getValue()) {
                //System.out.println("\tValue: " + connection.getCity().getCityname() + ", " + connection.getCity().getState());
            }
            System.out.println("\n");
        }
    }
}
