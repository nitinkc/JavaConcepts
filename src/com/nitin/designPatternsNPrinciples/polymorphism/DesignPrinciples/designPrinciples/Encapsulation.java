package com.nitin.designPatternsNPrinciples.polymorphism.DesignPrinciples.designPrinciples;

/**
 * Created by Nitin C on 3/5/2016.
 *
 * Data Encapsulation is the idea of combining fields and methods in a class such that the methods operate on the data.
 * as opposed to the users of the class accessing the fields
 *
 * Implemented with private instance fields which has public methods to access the fields directly
 */
public class Encapsulation {
    private int id;
    private String name;


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
