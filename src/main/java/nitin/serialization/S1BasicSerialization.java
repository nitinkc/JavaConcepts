package nitin.serialization;

import java.io.*;

/**
 * Created by nitin on 1/2/16.
 */
public class S1BasicSerialization {
    private static final String FILE_NAME =  "src/com/nitin/a21serialization/serialObject.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog d = new Dog();

        //Obtaining the File name
        File f = new File(FILE_NAME);

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
        objectOutputStream.writeObject(d);
        objectOutputStream.close();

        /** The Process of Deserialization needs File Input Stream to be able to read the Object from the File
         * The Object is written onto the FIS, which inturns gives it back to the OIS (ObjectInputStream)
         * */

        // Opening the Input Stream
        FileInputStream fileInputStream = new FileInputStream(f);

        // Opening the ObjectInput Stream
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        //Read the Object
        Dog d2 = (Dog) objectInputStream.readObject();
        objectInputStream.close();

        /* TESTING*/
        System.out.println(d2);
        System.out.println(d);

        System.out.println(d2.hashCode());
        System.out.println(d.hashCode());

    }
}

//IF serializable is not implemented then you get NotSerializableException
class Dog implements Serializable{
    String name = "Jackie";
    int age = 10;

    @Override
    public String toString(){
        return (this.name + " : " + this.age);
    }
}

