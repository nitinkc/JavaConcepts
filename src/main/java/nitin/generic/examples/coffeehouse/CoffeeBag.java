package nitin.generic.examples.coffeehouse;


public class CoffeeBag implements Bag {

    private double ounces;
    private CoffeeType type;

    public CoffeeBag(CoffeeType type, double ounces) {
        this.type = type;
        this.ounces = ounces;
    }

    @Override
    public double getWeight() {
        return this.ounces;
    }

    public void setWeight(double ounces) {
        this.ounces = ounces;
    }

    /**
     * @return the type
     */
    public CoffeeType getType() {
        return this.type;
    }

    /**
     * @param type the type to set
     */
    public void setType(CoffeeType type) {
        this.type = type;
    }

}
