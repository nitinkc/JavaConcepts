package java.LambdaExpressions;

/**
 * Created by Nitin C on 2/27/2016.
 * 4 Rules of Default Methods
 * 1. methods are automatically inherited eg
 * 2. Override a default method, if it doesnt find int he child, it goes up the hierarchy top chjeck the method out
 * 3. Methods in a class Hierarchy RULES!!
 * 4. if there is a collision in interface
 */
// Till Java 7, only method signature
// Now we can set to Default and implement

/* We cant throw away Abstract class because Interfaces cannot have state!! Abstract classes have states
 * u can put fields in abstract classes but u cannot out fields in interfaces
 * 2. you cannot inherit from more than one abstract class
 *
 * The GOLDEN RULE: Interfaces are better than classes
 * */

public class L2 {
    public void use() {
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

interface Fly{
    default void takeOff(){
        System.out.println("Fly::takeOff");
    }
    default void turn(){
        System.out.println("Fly::turn");
    }
    default void cruise(){
        System.out.println("Fly::cruise");
    }
    default void land(){
        System.out.println("Fly::land");
    }

}

interface FastFly extends Fly{
    @Override
    default void takeOff(){
        System.out.println("FastFly::TakeOff");
    }
}

// Demonstration of Rule 3 3
class Vehicle{
    public void land(){
        System.out.println("Vehicle::Land");
    }
}

interface Sail{
    default void cruise(){
        System.out.println("Sail::cruise");
    }
}

//default cruise method is available in both the interfaces
//SeaPlane inherits unrelated defaults for cruise() from types Fly and Sail
class SeaPlane extends Vehicle implements FastFly, Sail{
    //To avoid the method HAVE TO OVER WRITE
    public void cruise(){
        System.out.println("Seaplane::cruise");
        FastFly.super.cruise();//super has to be used because interfaces can have static methoids
        // If you dont use super, it will thin u are calling static method. with super, its default
    }
}
