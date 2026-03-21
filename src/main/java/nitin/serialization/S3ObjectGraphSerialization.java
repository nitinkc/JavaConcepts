package nitin.serialization;

import java.io.*;

/** Created by nitin on 1/2/16. */
public class S3ObjectGraphSerialization {
    private static final String FILE_NAME =
            "src/main/java/nitin/serialization/serialObjectGraph.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Serializing an object graph: every referenced object must be Serializable.
        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(new File(FILE_NAME)))) {
            oos.writeObject(new Animal());
        }

        // Deserialization
        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(new File(FILE_NAME)))) {
            Animal restored = (Animal) ois.readObject();
            System.out.println(restored);
        }
    }
}

class Animal implements Serializable {
    FourLeggedAnimal fla = new FourLeggedAnimal();

    @Override
    public String toString() {
        return "Animal{" + "fla=" + fla + '}';
    }
}

class FourLeggedAnimal implements Serializable {
    // If this class is not Serializable, Animal serialization fails with NotSerializableException.
    Horse h = new Horse();

    @Override
    public String toString() {
        return "FourLeggedAnimal{" + "h=" + h + '}';
    }
}

class Horse implements Serializable {
    String name = "Chetak";

    @Override
    public String toString() {
        return "Horse{" + "name='" + name + '\'' + '}';
    }
}
