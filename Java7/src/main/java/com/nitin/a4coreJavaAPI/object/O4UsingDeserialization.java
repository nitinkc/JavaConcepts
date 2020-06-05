package com.nitin.a4coreJavaAPI.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by nitin.chaurasia on 3/3/2017.
 */
public class O4UsingDeserialization {

    public static void main(String[] args) throws FileNotFoundException {

        Employee e = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/com/nitin/a21serialization/serialObject.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            e = (Employee) in.readObject();
            in.close();
            fileIn.close();

        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        System.out.println("Deserialized Employee...");
       // System.out.println("Name: " + e.name);
    }
}