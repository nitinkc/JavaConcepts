package nitin.kcura.oldSolution.part2;

import java.util.Comparator;

/**
 * Created by Nitin Chaurasia on 11/10/15
 *
 * Sort the List of Objects based on the Population
 * If there is a tie in the Population, Sorting is performed
 * first by the alphabetical order of the States and
 * the by the alphabetical order of the Cities
 * */
public class PopulationComparator implements Comparator<Data> {

    public static final int BIGGER = 1;
    public static final int SMALLER = -1;
    public static final int EQUAL = 0;

    @Override
    public int compare(Data obj1, Data obj2) {
        if (obj1 == obj2) {
            return EQUAL;
        } else if (obj1.getPopulation() < obj2.getPopulation()) {
            //Reverse Sorting as per the requirement
            return BIGGER;
        } else if (obj1.getPopulation() == obj2.getPopulation()) {
            return compareStates(obj1.getCity(), obj2.getCity());
        } else {
            return SMALLER;
        }
    }


    // Sorting based on alphabetical order of States (iff population is Same)
    private int compareStates(City obj1, City obj2) {
        if (obj1.getState().compareTo(obj2.getState()) > 0) {
            return BIGGER;
        } else if (obj1.getState().compareTo(obj2.getState()) < 0) {
            return SMALLER;
        } else {
            return compareCities(obj1, obj2);
        }
    }

    // Sorting based on alphabetical order of Cities (if population is same and the States are same)
    private int compareCities(City obj1, City obj2) {
        if (obj1.getCityname().compareTo(obj2.getCityname()) > 0) {
            return BIGGER;
        } else if (obj1.getCityname().compareTo(obj2.getCityname()) < 0) {
            return SMALLER;
        } else {
            // We will never meet this condition since as per assumptions, the input file will not contain same cities
            throw new IllegalArgumentException("Both Cities are same: " + obj1.getCityname() + ", " + obj2.getCityname());
        }
    }
}
