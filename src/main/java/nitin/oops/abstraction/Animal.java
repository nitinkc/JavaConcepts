package nitin.oops.abstraction;

/**
 * Created by Nitin Chaurasia on 3/6/16 at 11:48 PM.
 */
public abstract class Animal {
    protected int age;

    public void eat(){
        System.out.println("Animal is eating");
    }

    public abstract String getName();
}
