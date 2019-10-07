package com.nitin.javaMemoryModel;

/**
 * Created by nitin on Saturday, October/05/2019 at 11:40 PM
 */
public class JVM {
    public static void main(String... args) {
        System.out.println("Hello, world!"); //prints: Hello, world!
        for (String arg : args) {
            System.out.print(arg + " ");     //prints all program arguments
        }
        String p = System.getProperty("someParameter");
        System.out.println("\n" + p);               //prints value of VM option someParameter
    }
}
