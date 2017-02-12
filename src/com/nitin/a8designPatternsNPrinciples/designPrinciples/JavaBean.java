package com.nitin.a8designPatternsNPrinciples.designPrinciples;

/**
 * Created by Nitin C on 3/5/2016.
 *
 * Encapsulation si so prevalent in java that there is a standard for creating classes that store data, called JavaBean
 *
 * N1PathFileTest JavaBean is a design principle for encapsulating data in an OBJECT in Java
 *
 * JavaBean naming Convention
 * 1. Properties (variables and fields) are private
 * 2. Getter for non-boolean begins with get
 * 3. Getter for boolean MAY begin with get or is
 * 4. Setter methods must begin with b_set
 * 5. Method name must have a prefix of b_set/get/is followed by the First letter of property in Uppercase
 */
public class JavaBean {
    private int id;
    private String name;
    private boolean male;

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

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
}
