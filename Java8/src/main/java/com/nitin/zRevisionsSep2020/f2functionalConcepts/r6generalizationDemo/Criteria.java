package com.nitin.zRevisionsSep2020.f2functionalConcepts.r6generalizationDemo;

/**
 * @Author Created by nichaurasia
 * @create on Friday, September/18/2020 at 10:18 AM
 */

@FunctionalInterface
public interface Criteria<E> {
    boolean test(E e);
}