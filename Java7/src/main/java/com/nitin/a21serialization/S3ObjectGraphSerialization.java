package com.nitin.a21serialization;

import java.io.*;

/**
 * Created by nitin on 1/2/16.
 */
public class S3ObjectGraphSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Serializing Object
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src/com/nitin/a21serialization/serialObjectGraph.txt")));
        oos.writeObject(new Animal());
        oos.close();

        //Deserialization
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src/com/nitin/a21serialization/serialObjectGraph.txt")));
        Animal c = (Animal)ois.readObject();
        ois.close();

        System.out.println(c.fla.h.toString());

    }
}

class Animal implements Serializable{
    FourLeggedAnimal fla = new FourLeggedAnimal();
}

class FourLeggedAnimal implements Serializable{ // if implements serializable is not used : java.io.NotSerializableException: com.nitin.a21serialization.FourLeggedAnimal

    Horse h = new Horse();
}

class Horse implements Serializable{
    String name = "Chetak";

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                '}';
    }
}
