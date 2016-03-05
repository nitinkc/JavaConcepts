package com.nitin.nestedClasses.innerClass;

/**
 * Created by nitin on 1/14/16.
 *
 * Inner Class can only be accessed only through live instance of outer class
 */


interface Demo{
    public void show();
}

public class I1AnonymousClassDemo {
    public void data() {
        System.out.println("Outer Class");
    }

    public static void main(String[] args) {

        Demo demo=new Demo(){
            public void show() {
                System.out.println("show from Ano class...");
            }
        };

        I1AnonymousClassDemo ref=new I1AnonymousClassDemo(){
            public void data() {
                System.out.println("Outer Class");
            }
            public void display(){
                System.out.println("Display of Outer..");
            }
        };
        ref.data();
    }
}
