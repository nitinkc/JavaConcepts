package nitin.zOReiley2020SimonRoberts.f2functionalConcepts.r6generalizationDemo;

/**
 * @Author Created by nichaurasia
 * @create on Friday, September/18/2020 at 10:18 AM
 */

@FunctionalInterface
public interface Criteria<E> {
    boolean test(E e);
}