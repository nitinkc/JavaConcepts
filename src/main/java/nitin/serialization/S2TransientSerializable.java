package nitin.serialization;

import java.io.*;

/**
 * Created by nitin on 1/2/16.
 *
 * <p>Transient does not work when Static or Final is used
 */
public class S2TransientSerializable {
    private static final String FILE_NAME =
            "src/main/java/nitin/serialization/serialObjectTransient.txt";

    public static void main(String[] args) {

        // Serializing Object
        TestSerial testSerial =
                TestSerial.builder()
                        .name("Katie")
                        .age(5) // transient fields are skipped
                        .password("TESTING")
                        .someChar('%')
                        .finalTransientString("Final + transient still skips serialization")
                        .build();

        // Testing for the Final
        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(new File(FILE_NAME)))) {
            oos.writeObject(testSerial);
            System.out.println(testSerial);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(new File(FILE_NAME)))) {
            TestSerial c = (TestSerial) ois.readObject();
            System.out.println(
                    "*********************** After Deserialization ****************************");
            System.out.println(c);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
