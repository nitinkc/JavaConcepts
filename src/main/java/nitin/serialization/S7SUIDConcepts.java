package nitin.serialization;

import java.io.*;

/**
 * Created by nitin on 1/3/16.
 */
public class S7SUIDConcepts {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {

        File f = new File("src/com/nitin/a21serialization/suidTest.out");
        Serialtest st1 = new Serialtest(1000);
        Serialtest st2 = new Serialtest(1000);


        // serialize
//        FileOutputStream fos = new FileOutputStream(f);
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//        System.out.println("Serialization done.");
//        oos.writeObject(st1);
//        oos.close();

        // helpful in deep a22cloning
        // deserialize
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Serialtest deserializedObj = (Serialtest) ois.readObject();

        System.out.println("DeSerialization done. accn: " + deserializedObj);
        ois.close();
    }
}

// invalid classException will only be thrown when some modification is done
// in the class and that modification has to do with the state of the a5object.
// provided serialversion uid is not defined explicitly
class Serialtest implements Serializable {
    private static final long serialVersionUID = 1L;
    // serialversionuid is computed by compiler
    int a;
    int f;
    static int x = 0; // static variables are not serialized  212236
    transient int y = 0;// transient variables are not serialized
    int bb = 0;

    int newVarAfterDeclaringSUID = 9;


    //Named Constructor
    public Serialtest(int a) {
        this.a = a; // similarly methods are not serialized
    }

    //Methods
    public void f1() {

    }

    public void m1new() {
    }

    public void m2() {
        System.out.println(" changes done to methos check and compare with saved a5object");
    }

    // conclusion if we try to add a method or remove a method than it does not
    // effects the state of the a5object.
    public void m4() {
        int a = 9;
        System.out.println(a);
    }

    @Override
    public String toString() {
        return "Serialtest{" +
                "a=" + a +
                ", f=" + f +
                ", y=" + y +
                ", bb=" + bb +
                ", newvariableafterdeclaringserialversiouid=" + newVarAfterDeclaringSUID +
                '}';
    }
}
