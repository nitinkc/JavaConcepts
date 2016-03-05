package com.nitin.functionalProgramming;

/**
 * Created by Nitin C on 3/3/2016.
 */

//Three input parameters and the last one is the Output parameter
public interface MyFunction<T,U,V,R> extends FunctionalInterface{
    R apply(T t, U u, V v);

}
