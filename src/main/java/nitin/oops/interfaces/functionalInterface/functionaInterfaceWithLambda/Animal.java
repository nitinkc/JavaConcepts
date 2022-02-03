package nitin.oops.interfaces.functionalInterface.functionaInterfaceWithLambda;

/**
 * Created by Nitin Chaurasia on 5/9/16 at 10:45 PM.
 */
public class Animal {
    private final String species;
    private final boolean canHop;
    private final boolean canSwim;

    public Animal(String species, boolean canHop, boolean canSwim) {
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    public boolean isCanHop() {
        return canHop;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                '}';
    }
}
