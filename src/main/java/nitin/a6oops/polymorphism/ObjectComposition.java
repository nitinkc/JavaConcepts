package nitin.a6oops.polymorphism;

/**
 * Created by Nitin C on 3/5/2016.
 * Object Composition is a property of constructing a class using references to other classes in order to reuse
 * the functionality of other classes.
 * <p>
 * Object Composition is used to SIMULATE the polymorphic behaviour that cannot be achieved via single inheritance
 */
public class ObjectComposition {
}

/* Composing a class Penguin that contains both of these objects and delegates its methods to them
 * One of the advantage of OC over Inheritance is greater code reuse. By using OC you gain access to other classes
 * and methods that would be difficult to obtain via Java's single inheritance model!!
 * */
class Penguin {
    private final Flippers flippers;
    private final WeddedFeet weddedFeet;

    public Penguin() {
        this.flippers = new Flippers();
        this.weddedFeet = new WeddedFeet();
    }

    public void flap() {
        this.flippers.flap();
    }

    public void kick() {
        this.weddedFeet.kick();
    }
}

class Flippers {
    public void flap() {
        System.out.println("The flippers flap back and forth");
    }
}

class WeddedFeet {
    public void kick() {
        System.out.println("The Wedded Feet kick to and fro");
    }
}