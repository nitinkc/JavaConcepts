package com.nitin.serialization;

import java.io.*;

/**
 * Created by nitin on 1/2/16.
 */
public class S2TransientSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Serializing Object
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src/com/nitin/serialization/serialObjectCat.txt")));
        oos.writeObject(new Cat());
        oos.close();

        //Deserialization
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src/com/nitin/serialization/serialObjectCat.txt")));
        Cat c = (Cat)ois.readObject();
        ois.close();

        System.out.println(c);
    }
}

class Cat implements Serializable {
    String name = "Katie";

    //The transient variable does not participate in the serialization process
    // It takes defalut values
    transient int age = 5;
    transient String test = "TESTING";
    transient char c = '%';
    //Testing final transient. Final overpowers adn thus there is no effect of transient
    final transient String ftString = "Final Transient String showing";

    //Simularly there is no effect of static transient
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
