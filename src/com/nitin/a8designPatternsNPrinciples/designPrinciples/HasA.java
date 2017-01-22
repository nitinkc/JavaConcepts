package com.nitin.a8designPatternsNPrinciples.designPrinciples;

/**
 * Created by Nitin C on 3/5/2016.
 * Has-N1PathFileTest relationship is a property of an object having a named data object or primitive as a member!!
 *
 * In inheritance, is a parent has-a PROTECTED/PUBLIC member, then any child of parent must also
 * have the object as member.
 *
 * NOTE: PRIVATE MEMBERS ARE NOT INHERITED IN JAVA
 */
public class HasA {

}

class Bird{
    Beak beak; //Bird HAS-N1PathFileTest Beak
    String color;
    String category;
}

class Beak{
    String color;
    double length;
}