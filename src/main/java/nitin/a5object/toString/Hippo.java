package nitin.a5object.toString;

/** Created by Nitin Chaurasia on 3/4/16 at 11:01 PM. */
public class Hippo {
    private final String name;
    private final double weight;

    public Hippo(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    // Explicit to String Example
    @Override
    public String toString() {
        return "Hippo{" + "name='" + name + '\'' + ", weight=" + weight + '}';
    }
}
