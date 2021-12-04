package java7.a10collections.d_maps.TreeMap;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeMapComparatorObjectKey {
    public static void main(String[] args) {
        Set<City> set = new TreeSet<>(new CityComparator());

        set.add(new City("Bowling Green", "OH",43402));
        set.add(new City("Bowling Green", "KA",43402));
        set.add(new City("Fremont", "CA",94538));
        set.add(new City("Clarks Summit", "PA",18411));
        set.add(new City("Irvine", "CA",92620));
        set.add(new City("Sanford", "FL",32771));
        set.add(new City("Sanford", "FL",32772));
        set.add(new City("Sanford", "FL",32773));


        for (City city:
             set) {
            System.out.println(city);
        }
    }
}

// Comparable can be used here so that the Objects are comparable and be used directly.
// Writing a separate Comparator to further customize the
class City{

    //Integer is used so that City.getZip1.compareTo(City.getZip2) be used
    String name;
    String state;
    Integer zip;

    public City(String name, String state, Integer zip) {
        this.name = name;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}

// Comparator of City is used so that Object Casting can be avoided
class CityComparator implements Comparator<City> {

    @Override
    public int compare(City c1, City c2) {
        //Level 1 Comparison : City Name (Reverse Sorted)
        int cityCompare = c2.getName().compareTo(c1.getName());
        //Level 2 Comparison : State
        int stateCompare = c1.getState().compareTo(c2.getState());
        //Level 3 Comparison : Zip
        int zipCompare = c2.getZip().compareTo(c1.getZip());

        if (cityCompare != 0)
            return cityCompare;
        if(cityCompare == 0 && stateCompare != 0)
            return  stateCompare;
        //if ( cityCompare == 0 && stateCompare == 0 && zipCompare != 0)
            return zipCompare;

    }
}