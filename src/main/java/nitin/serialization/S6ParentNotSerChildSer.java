package nitin.serialization;

import java.io.*;

/**
 * Created by nitin on 1/3/16.
 */
public class S6ParentNotSerChildSer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src/com/nitin/a21serialization/serialObjectInherited.txt")));
        FourVehicle dp = new FourVehicle();
        //This will be serialized
        dp.b = 244224;
        //Super class is not serialised, this this will not go
        dp.a = 10;
        oos.writeObject(dp);
        oos.close();

        //Deserialization
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src/com/nitin/a21serialization/serialObjectInherited.txt")));
        FourVehicle c = (FourVehicle) ois.readObject();
        System.out.println(c);
        ois.close();
    }
}

class Vehicle {
    int a = 90;

    Vehicle() {
    }
}

//Since Parent has Serializable implemeted, Chine need not be so
class FourVehicle extends Vehicle implements Serializable {
    int b = 45;

    FourVehicle() {

    }

    @Override
    public String toString() {
        return "FourVehicle{" +
                "b=" + b +
                "super.a=" + a +
                '}';
    }
}
