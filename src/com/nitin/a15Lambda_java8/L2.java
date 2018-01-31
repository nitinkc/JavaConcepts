package com.nitin.a15Lambda_java8;

/**
 * Created by Nitin C on 2/27/2016.
 */

//Till Java 7, only method signaturr
// Now we can b_set to Derfault anf implement

interface Fly{
    default public void takeOff(){
        System.out.println("Fly::takeOff");
    }
    default public void turn(){
        System.out.println("Fly::turn");
    }
    default public void cruise(){
        System.out.println("Fly::cruise");
    }
    default public void land(){
        System.out.println("Fly::land");
    }

}

/**
 * 4 Rules od Default Methods
 * 1. methods are automatically inherited eg
 * 2. Override a default method, if it doesnt find int he child, it goes up the hierarchy top chjeck the method out
 * 3. Methodfs in a class Heirarch RULES!!
 * 4. if there is a cllision in interface
 */
interface FastFly extends Fly{
    @Override
    default public void takeOff(){
        System.out.println("FastFly::TakeOff");
    }
}

// Demontration of Rule 3 3
class Vehicle{
    public void land(){
        System.out.println("Vehicle::Land");
    }
}

interface Sail{
    default public void cruise(){
        System.out.println("Sail::cruise");
    }
}

//default cruise method is available in both the interfaces
//SeaPlane inherits unrelated defaults for cruise() from types Fly and Sail
class SeaPlane extends Vehicle implements FastFly, Sail{
    //To avoid the method HAVE TO OVER WRITE
    public void cruise(){
        System.out.println("Seaplane::cruise");
        FastFly.super.cruise();//supse has to be used because interfaces can have static methoids
        // If you dont use super, it will thin u are calling static method. with super, its default
    }

}

/* We cant throw away Abstract class becasue Interfaces cannot have state!! Abstract classes have states
* u can put fields in abstract classes but u cannot out fields in uionterfaces
* 2. you cannot inherit from more than one abstract class
*
* The GOLDEN RULE: Interfaces are better thjan classes
* */

public class L2 {
    public void use(){
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();//Calls from fast Fly, the nearest implementation
        seaPlane.turn();
        seaPlane.cruise();
        // which land, vehicle land or Fly land
        seaPlane.land();//if the method is in class hierarchy, thjat methid rules!!
    }
    public static void main(String[] args) {
        new L2().use();
    }
}
