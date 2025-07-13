package nitin.a6oops.abstraction;

/** Created by nitin on Sat, 1/14/17 at 9:06 PM. */
public abstract class Car {
    public abstract void engine();

    // Partial implementation
    public void blowHorn() {
        System.out.println("Honk - Honk");
    }
}
