package java.collections.b_set;

import java.util.*;

/**
 * Created by nitin on Saturday, August/24/2019 at 22:07
 */
public class S4TreeSetOfObjects {


    public static void main(String[] args) {

        Car a = new Car("Honda","CRV", new int[]{05,2019},
                new ArrayList<String>(Arrays.asList("AWD", "Leather", "Sun Roof","Grey Interior")));
        Car b = new Car("Toyota","RAV4", new int[]{03,2019},
                new ArrayList<String>(Arrays.asList("2WD", "Cotton", "Sun Roof","Grey Interior")));
        Car c = new Car("Honda","Accord", new int[]{03,2018},
                new ArrayList<String>(Arrays.asList("AWD", "Leather", "Sun Roof","Grey Interior")));
        Car d = new Car("Toyota","Camry", new int[]{06,2018},
                new ArrayList<String>(Arrays.asList("2WD", "Cotton", "Sun Roof","Grey Interior")));

        Set<Car> set = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                //Level 1 Comparison : Make
                int l1 = o1.make.compareTo(o2.make);

                //Level 2 Comparison : Based on year made

                //Level 3 Comparison : Based on Facilities
                return 0;
            }
        });
        set.add(a);
        set.add(b);
        set.add(c); set.add(d);

        Iterator<Car> itr = set.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

class Car{
    String model;
    String make;
    int [] yymm;
    ArrayList<String> facilities;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int[] getYymm() {
        return yymm;
    }

    public void setYymm(int[] yymm) {
        this.yymm = yymm;
    }

    public ArrayList<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<String> facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", yymm=" + Arrays.toString(yymm) +
                ", facilities=" + facilities +
                '}';
    }

    public Car(String model, String make, int[] yymm, ArrayList<String> facilities) {
        this.model = model;
        this.make = make;
        this.yymm = yymm;
        this.facilities = facilities;
    }
}
