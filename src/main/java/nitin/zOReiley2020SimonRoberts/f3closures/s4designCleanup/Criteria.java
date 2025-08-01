package nitin.zOReiley2020SimonRoberts.f3closures.s4designCleanup;

/**
 * @author Created by nichaurasia Created on Friday, September/18/2020 at 10:18 AM
 */
@FunctionalInterface
public interface Criteria<E> {
    boolean test(E e);

    default Criteria<E> and(Criteria<E> crit2) {
        return x -> this.test(x) && crit2.test(x);
    }

    default Criteria<E> or(Criteria<E> crit2) {
        return x -> this.test(x) || crit2.test(x);
    }

    default Criteria<E> negate() {
        return x -> !this.test(x);
    }
}
