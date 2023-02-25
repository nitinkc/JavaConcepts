package nitin.serialization;

import java.io.*;

/**
 * Created by nitin on 1/2/16.
 * <p>
 * Transient does not work when Static or Final is used
 */
public class S2TransientSerializable {
    public static void main(String[] args) {

        //Serializing Object
        TestSerial testSerial = TestSerial.builder()
                .name("Katie")//The transient variable does not participate in the serialization process. It takes defalut values
                .age(5)
                .password("TESTING")
                .someChar('%')
                .finalTransientString("Final Transient String showing")//Testing final transient. Final overpowers and thus there is no effect of transient
                .build();

        //Testing for the Final
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src/main/java/nitin/serialization/serialObjectTransient.txt")));) {
            oos.writeObject(testSerial);
            System.out.println(testSerial);
        } catch (FileNotFoundException e)  {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Deserialization
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src/main/java/nitin/serialization/serialObjectTransient.txt")))) {
            TestSerial c = (TestSerial) ois.readObject();
            ois.close();
            System.out.println("*********************** After Deserialization ****************************");
            System.out.println(c);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

