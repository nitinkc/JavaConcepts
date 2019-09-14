package com.nitin.a21serialization;

import java.io.*;

/**
 * Created by nitin on 1/2/16.
 * Transient Keyword leads to the Loss of Information,
 * This can be controlled by Customized Serialization
 */
public class S4CustomizedSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Serializing Object
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src/com/nitin/a21serialization/serialObjectCoustomized.txt")));
        Login l = new Login();
        // Call the overridden writeObject from the class Login
        oos.writeObject(l);
        oos.close();

        //Deserialization
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src/com/nitin/a21serialization/serialObjectCoustomized.txt")));

        // Call the overridden readObject from the class Login
        Login c = (Login)ois.readObject();
        ois.close();

        System.out.println(l.uname +" : "+l.pwd);
        System.out.println(c.uname +" : "+c.pwd);
    }
}

class Login implements Serializable {
    String uname = "Nitin";
    transient String pwd = "123@abc##";//Passwords are transient because do not sent over inter net as a string

    //Automatically executed at the time of Serialization. PRIVATE METHOD, NOT PUBLIC
    private void writeObject(ObjectOutputStream os) throws Exception{
        //perform default a21serialization (Nitin...null) 
        os.defaultWriteObject();

        //Encrypting the password (!@#@$123@abc##) 
        String epwd = "!@#@$" + pwd;
        os.writeObject(epwd);// write it as a separate object 
    }

    // Automatically executed at the time of De-Serialization
    private void readObject(ObjectInputStream is) throws Exception {
        is.defaultReadObject();
        String epwd = (String)is.readObject();
        pwd = epwd.substring(5);//Decripting the password 
    }
}