package nitin.zKnowYourJava;

import nitin.zKnowYourJava.T7.Derived;

public class T7Inheritance {
    public static void main(String[] args) {
        try {
            new Derived("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
