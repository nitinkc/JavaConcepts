package nitin.serialization;

import java.io.*;

/** Created by nitin on 1/2/16. */
public class S5ParentSerChildNot {
    private static final String FILE_NAME =
            "src/main/java/nitin/serialization/serialObjectInherited.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DeciduousPlants deciduousPlants = new DeciduousPlants();
        ConiferousPlants coniferousPlants = new ConiferousPlants();

        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(new File(FILE_NAME)))) {
            // Parent is Serializable, so the child is Serializable by inheritance.
            oos.writeObject(deciduousPlants);

            // This child deliberately blocks serialization in writeObject.
            oos.writeObject(coniferousPlants);
        }

        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(new File(FILE_NAME)))) {
            // Read back in the same order they were written.
            DeciduousPlants restoredDeciduous = (DeciduousPlants) ois.readObject();
            ConiferousPlants restoredConiferous = (ConiferousPlants) ois.readObject();

            System.out.println(restoredDeciduous);
            System.out.println(restoredConiferous);
        }
    }
}

class Plants implements Serializable {
    private static final long serialVersionUID = 1L;
    int a = 90;
}

// Since parent has Serializable, the child is also Serializable.
class DeciduousPlants extends Plants {
    int b = 45;

    @Override
    public String toString() {
        return "DeciduousPlants{" + "b=" + b + '}';
    }
}

// Now we don't want this child class to be Serialised, so throw NotSerializableException from the
// over ridden writeObject Class
class ConiferousPlants extends Plants {
    int c = 40;

    private void writeObject(ObjectOutputStream os) throws NotSerializableException {
        throw new NotSerializableException(
                "ConiferousPlants intentionally blocks Java serialization.");
    }

    @Override
    public String toString() {
        return "ConiferousPlants{" + "c=" + c + '}';
    }
}
