package nitin.serialization;

import java.io.*;

/** Created by nitin on 1/2/16. */
public class S1BasicSerialization {
    private static final String FILE_NAME = "src/main/java/nitin/serialization/serialObject.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestSerial original = buildSampleObject();

        // Obtaining the File name
        File file = ensureFile(FILE_NAME);

        /**
         * The Process of Serialization needs File Output Stream to write the Object into the File
         * The Object is written onto the FOS, which inturns writes it in the File
         */
        serialize(file, original);

        /**
         * The Process of Deserialization needs File Input Stream to be able to read the Object from
         * the File The Object is written onto the FIS, which inturns gives it back to the OIS
         * (ObjectInputStream)
         */
        TestSerial roundTrip = deserialize(file);
        printComparison(original, roundTrip);
    }

    private static TestSerial buildSampleObject() {
        return TestSerial.builder()
                .name("Katie")
                .age(5) // transient fields are skipped and reset to defaults on read
                .password("TESTING")
                .someChar('%')
                .finalTransientString("Final transient values are also skipped")
                .build();
    }

    private static File ensureFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Created File...");
        }
        return file;
    }

    private static TestSerial deserialize(File file) throws IOException, ClassNotFoundException {
        // ObjectInputStream reads serialized bytes from the file.
        try (ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(file))) {
            return (TestSerial) objectInputStream.readObject();
        }
    }

    private static void serialize(File file, TestSerial data) throws IOException {
        // ObjectOutputStream writes serialized bytes to the file.
        try (ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(data);
        }
    }

    private static void printComparison(TestSerial original, TestSerial roundTrip) {
        System.out.println("Original  : " + original);
        System.out.println("Round-trip: " + roundTrip);
        System.out.println("Original hash: " + original.hashCode());
        System.out.println("Read hash    : " + roundTrip.hashCode());
    }
}
