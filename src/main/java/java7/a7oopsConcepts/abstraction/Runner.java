package java7.a7oopsConcepts.abstraction;

/**
 * Created by nitin on Sat, 1/14/17 at 9:10 PM.
 */
public class Runner {
    public static void main(String[] args) {
        Car p1 = new Swift();
        p1.engine();
        p1.blowHorn();

        Car p2 = new Polo();
        p2.engine();
        p2.blowHorn();
    }
}
