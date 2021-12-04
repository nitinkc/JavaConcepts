package java7.a21serialization;

import java.io.*;

/**
 * Created by nitin on 1/2/16.
 *
 * Transient does not work when Static or Final is used
 */
public class S2TransientSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Serializing Object
        Cat cCat = new Cat();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src/com/nitin/a21serialization/serialObjectTransient.txt")));
        oos.writeObject(cCat);
        oos.close();
        System.out.println(cCat);

        //Deserialization
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src/com/nitin/a21serialization/serialObjectTransient.txt")));
        Cat c = (Cat)ois.readObject();
        ois.close();
        System.out.println("*********************** After Deserialization ****************************");
        System.out.println(c);
    }
}

class Cat implements Serializable {
    String name = "Katie";

    //The transient variable does not participate in the a21serialization process
    // It takes defalut values
    transient int age = 5;
    transient String test = "TESTING";
    transient char c = '%';
    //Testing final transient. Final overpowers and thus there is no effect of transient
    final transient String ftString = "Final Transient String showing";

    //Similarly there is no effect of static transient
    static transient String stString = "Static Transient String showing";


    //Testing for the Static variable. Static variables are NOT The part of Object,
    //The are the part of Class
    static int staticInt = 342324;

    //Testing for the Final

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", test='" + test + '\'' +
                ", c=" + c +
                ", ftString=" + ftString +
                ", stString=" + stString +
                ", staticInt=" + staticInt +
                '}';
    }
}
