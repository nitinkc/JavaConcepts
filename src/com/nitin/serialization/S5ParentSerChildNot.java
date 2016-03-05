package com.nitin.serialization;

import java.io.*;

/**
 * Created by nitin on 1/2/16.
 */
public class S5ParentSerChildNot {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src/com/nitin/serialization/serialObjectInherited.txt")));
        DecidiousPlants dp = new DecidiousPlants();
        ConiferousPlants cp = new ConiferousPlants();

        // Call the overridden writeObject from the class Login
        oos.writeObject(dp);
        oos.writeObject(cp);
        oos.close();

        //Deserialization
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src/com/nitin/serialization/serialObjectInherited.txt")));

        /* Since we know the ORDER of insertion in Serialization, no exception else ClassCastException */
        DecidiousPlants decidiousPlants = (DecidiousPlants) ois.readObject();
        ConiferousPlants coniferousPlants = (ConiferousPlants) ois.readObject();

        ois.close();

        System.out.println(decidiousPlants);
        System.out.println(coniferousPlants);
    }
}

class Plants implements Serializable {
    int a = 90;

}

//Since Parent has Serializable implemeted, Chine need not be so
class DecidiousPlants extends Plants {
    int b = 45;

    @Override
    public String toString() {
        return "DecidiousPlants{" +
                "b=" + b +
                '}';
    }
}

//Now we don't want this child class to be Serialised, so throw NotSerializableException from the over ridden writeObject Class
class ConiferousPlants extends Plants{
    int c = 40;

    private void writeObject(ObjectOutputStream os) throws NotSerializableException {
        throw new NotSerializableException("You are trying to flattern the wrong guy nigga...");
    }

    @Override
    public String toString() {
        return "ConiferousPlants{" +
                "c=" + c +
                '}';
    }
}
