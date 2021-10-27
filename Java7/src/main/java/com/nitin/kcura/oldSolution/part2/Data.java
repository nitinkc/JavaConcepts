package com.nitin.kcura.oldSolution.part2;

import java.util.Set;

/**
 * Created by Nitin Chaurasia on 11/9/15 at 11:06 PM.
 */
public class Data{

    private int population;

    // City class contains city name and its corresponding state
    private City city;

    // Interstates are already sorted during the time of reading from the file using InterStateComparator order
    // (increasing order sort of alphanumeric key).
    private Set<String> interstates;

    // Accessors and Mutators for the private data members
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    //CHANGE : Putting interstates in a Set
    public Set<String> getInterstates() {
        return interstates;
    }

    public void setInterstates(Set<String> interstates) {
        this.interstates = interstates;
    }

    @Override
    /* Writes the names of the cities in the desired format
    * */
    public String toString() {
        String value = "";
         value = value + population + "\n\n" + city.toString() + "\n" + "Interstates: " +
                 interstatesToString(getInterstates()) + "\n";
        return value;
    }

    /* Writes the data when the cities have the same population as per the requirements
    * */
    public String aggragateCities() {
        String value = "";
        value = city.toString() + "\n" + "Interstates: " +
                interstatesToString(interstates) + "\n";
        return value;
    }

    /* Method to Print List of Interstates in the required format
     */
    public String interstatesToString(Set<String> iStates){
        String result = "";
        for (String interstates : iStates) {
            result += interstates + ", " ;
        }
        return result;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        } else if (!(obj instanceof Data)) {
            return false;
        } else {
            return this.getCity().equals(((Data) obj).getCity());
        }
    }

    @Override
    public int hashCode() {
        return (city.getCityname() + city.getState()).hashCode();
    }


}
