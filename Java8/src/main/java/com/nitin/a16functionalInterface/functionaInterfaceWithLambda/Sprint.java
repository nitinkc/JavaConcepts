package com.nitin.a16functionalInterface.functionaInterfaceWithLambda;

import com.nitin.a16functionalInterface.functionaInterfaceWithLambda.Animal;

/**
 * Created by Nitin C on 3/5/2016.
 *
 * Java compiler implicitly assumes any interface that contains exactly one abstract method as functional Interface
 */

@FunctionalInterface
public interface Sprint {
    public void sprint(Animal animal);

}
