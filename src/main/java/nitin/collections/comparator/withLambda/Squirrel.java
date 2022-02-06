package nitin.collections.comparator.withLambda;

/**
 * Created by Nitin C on 3/3/2016.
 */
public class Squirrel {

    private String species;
    private int weight;

    public String getSpecies() {
        return species;
    }

    public Squirrel(String species, int weight) {
        this.species = species;
        this.weight = weight;
    }

    public Squirrel(String theSpecies) {
        if (theSpecies == null)
            throw new IllegalArgumentException();
        else
            this.species = theSpecies;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Squirrel{" +
                "species='" + species + '\'' +
                ", weight=" + weight +
                '}';
    }
}
