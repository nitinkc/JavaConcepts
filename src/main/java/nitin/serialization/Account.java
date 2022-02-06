package nitin.serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Nitin Chaurasia on 8/2/15 at 12:37 AM.
 */
public class Account implements Serializable {
    String un = "Durga";
    transient String pwd = "Anushka";

    /* Automatically executed at the time of Serialization */
    public void writeObject(ObjectOutputStream os) throws Exception {
        os.defaultWriteObject();//perform default serialization (Durga...null)
        String epwd = "123" + pwd; //Encrypting the password (123Anushka)
        os.writeObject(epwd);// write it as a separate object
    }

    /* Automatically executed at the time of De-Serialization */
    public void readObject(ObjectInputStream is) throws Exception {
        is.defaultReadObject();
        String epwd = (String) is.readObject();
        pwd = epwd.substring(3);//Decripting the password
    }
}