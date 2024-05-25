package nitin.a6oops.interfaces.f1functionalFoundation.r4CommandPatternSelection;

public class GasLevelCarCriterion implements CarCriteria {

    private final int threshold;

    public GasLevelCarCriterion(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(Car car) {
        return car.getGasLevel() >= threshold;
    }
}
