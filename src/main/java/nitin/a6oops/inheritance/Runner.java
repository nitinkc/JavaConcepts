package nitin.a6oops.inheritance;

public class Runner {
    public static void main(String[] args) {
        /* Animal has animalMethod(), Dog extends Animal and has dogMethod() */
        Animal p = new Animal();
        p.animalMethod(); // Valid
        // p.dogMethod();// Compile time error: Cannot find symbol

        Dog c = new Dog();
        c.animalMethod(); // valid, as child inherits from parent
        c.dogMethod(); // valid as child provides implementation dogMethod

        Animal pc = new Dog(); // Polymorphic Call
        pc.animalMethod(); // valid as pc is of type Parent
        // pc.dogMethod();// invalid, CE : Cannot find symbol
    }
}
