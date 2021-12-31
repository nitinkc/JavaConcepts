package java.kcura.oldSolution.part1;

import java.util.List;

/**
 * Created by Nitin Chaurasia on 11/9/15 at 11:06 PM.
 */
public class Data{

    private int population;
    private String city;
    private String state;
    // Interstates are already sorted during the time of reading from the file using Default Sorting order.
    private List<String> interstates;

    // Accessors and Mutators for the private data members
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getInterstates() {
        return interstates;
    }

    public void setInterstates(List<String> interstates) {
        this.interstates = interstates;
    }

    @Override
    /* Formats the data like population, name of cities and states in the desired format
    *  It takes the help of the interstatesToString method for printing the names of the
    *  interstates.
    * */
    public String toString() {
        String value = "";
         value = value + population + "\n\n" + city + ", " + state + "\n" + "Interstates: " +
                 interstatesToString(getInterstates()) + "\n";
        return value;
    }

    /* Formats the data when the cities have the same population as per the requirements
    *  Cities with same population should be clubbed together.
    * */
    public String aggragateCities() {
        String value = "";
        value = city + ", " + state + "\n" + "Interstates: " +
                interstatesToString(interstates) + "\n";
        return value;
    }


    /* Method to Print List of Interstates in the required format
     */
    public String interstatesToString(List iStates){
        String result = "";
        for (int i = 0; i < iStates.size() - 1; i++) {
            result += iStates.get(i) + ", " ;
        }
        // Avoiding off-by-one error in comma
        // the last name of the city should not end with a comma.
        result = result + iStates.get(iStates.size()-1);

        return result;
        }

}
