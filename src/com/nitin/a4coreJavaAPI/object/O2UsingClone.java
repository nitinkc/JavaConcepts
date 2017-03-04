package com.nitin.a4coreJavaAPI.object;

import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 * Created by nitin.chaurasia on 3/3/2017.
 */
public class O2UsingClone {
    public static void main(String[] args) {

        Empcloneable e = new Empcloneable(2, "Nitin");
        System.out.println(e.name);

        try {
            Empcloneable b = e.clone();
            System.out.println(b.name);

        } catch (CloneNotSupportedException e1) {

            e1.printStackTrace();
        }
    }
}

class Empcloneable implements Cloneable {
    int a;
    String name;


    Empcloneable(int a, String name) {
        this.a = a;
        this.name = name;
    }

    @Override
    public Empcloneable clone() throws CloneNotSupportedException {
        return (Empcloneable) super.clone();
    }
}
