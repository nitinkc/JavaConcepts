package nitin.kcura.java8Solution.part2;

/**
 * Created by Nitin Chaurasia on 11/10/15 at 11:20 PM.
 */
public class City {

    private String cityname;
    private String state;

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //Constructor
    public City(String city, String state) {
        this.cityname = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return this.cityname + ", " + this.state;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        } else if (!(obj instanceof City)) {
            return false;
            // Checking the city names under all the conditions, cities can be in lower case.
            // If both city name and state name are equal return true
        } else
            return ((City) obj).getCityname().toLowerCase().equals(cityname.toLowerCase()) && ((City) obj).getState().toLowerCase().equals(state.toLowerCase());
    }
}
