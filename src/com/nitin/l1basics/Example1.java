package com.nitin.aug2415;

class A {

    public void music() {
        System.out.println(" this is from music ");
    }

    /* Method overloading */
    int music(int disk) {
        System.out.println(" this is from overloaded music");
        return disk;
    }
}

public class Example1 {
    public static void main(String[] args) {
        A obj = new A();
        obj.music();
        obj.music(2);
    }

}
