package nitin.oops.interfaces.f1functionalFoundation.r3SortCarsPreJava8;

import java.util.Comparator;

class PassengerCountOrder implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPassengers().size() - o2.getPassengers().size() ;
    }
}
