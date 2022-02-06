package nitin.oops.polymorphism;

/**
 * Created by nitin.chaurasia on 3/4/2017.
 * <p>
 * Dynamic polymorphism in Java is achieved by method overriding
 * As the method to call is determined at runtime, this is called dynamic binding or late binding.
 */
public class P3DynamicBinding {
    public static void main(String[] args) {

        Vehicle vh = new MotorBike();

        vh.move();    // prints MotorBike can move and accelerate too!!

        vh = new Vehicle();

        vh.move();    // prints Vehicles can move!!

    }
}

class Vehicle {

    public void move() {

        System.out.println("Vehicles can move!!");

    }
}

class MotorBike extends Vehicle {

    public void move() {

        System.out.println("MotorBike can move and accelerate too!!");

    }
}
