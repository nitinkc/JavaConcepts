package com.nitin.a.sandBox;

import java.io.File;

/**
 * Created by nitin on Wed, 3/8/17 at 9:21 PM.
 */


public class Child {

    public static void main(String args[]) {
        File file = new File("test.txt");
        File backup = new File("test.txt.bak");
        backup.delete();
        System.out.println(file.renameTo(backup)); //Location 1
    }
}