package com.nitin.zjava9.factoryMethodsForUnmodifiableCollection;

import java.io.*;
import java.util.List;

/**
 * Created by Nitin Chaurasia on 2/1/18 at 12:47 AM.
 */
public class F4SerializationWRTunmodifiableColl {
    private static final String FILE_NAME =  "src/com/nitin/a15java9/factoryMethodsForUnmodifiableCollection/serialization.txt";

    public static void main(String[] args) throws IOException,ClassNotFoundException{

        //Obtaining the File name
        File f = new File(FILE_NAME);

        //Creating unmodifiable Collection
        List<Integer> list = List.of(1,2,3,4,5);

        //Checking if the File exists or not
        if(!f.exists()){
            f.createNewFile();
            //If file by that name does not exist, then create the file
            System.out.println("Created File...");
        }

        /** The Process of Serialization needs File Output Stream to write the Object into the File
         * The Object is written onto the FOS, which inturns writes it in the File
         * */
        // File Output Stream is needed by ObjectOutputStream
        FileOutputStream fileOutputStream = new FileOutputStream(f);

        // OOS writes the Object into the File
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        // Serialized data is persisted!!
        objectOutputStream.writeObject(list);
        objectOutputStream.close();

        /** The Process of Deserialization needs File Input Stream to be able to read the Object from the File
         * The Object is written onto the FIS, which inturns gives it back to the OIS (ObjectInputStream)
         * */

        // Opening the Input Stream
        FileInputStream fileInputStream = new FileInputStream(f);

        // Opening the ObjectInput Stream
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        //Read the Object
        List<Integer> d2 = (List) objectInputStream.readObject();
        System.out.println(d2);
        objectInputStream.close();

        // Test that list remains unmodifiable even after Deserialization
        //d2.add(4);//java.lang.UnsupportedOperationException


    }
}
