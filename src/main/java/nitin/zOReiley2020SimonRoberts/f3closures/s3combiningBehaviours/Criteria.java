package nitin.zOReiley2020SimonRoberts.f3closures.s3combiningBehaviours;

/**
 * @author Created by nichaurasia Created on Friday, September/18/2020 at 10:18 AM
 */
@FunctionalInterface
public interface Criteria<E> {
    boolean test(E e);
}
